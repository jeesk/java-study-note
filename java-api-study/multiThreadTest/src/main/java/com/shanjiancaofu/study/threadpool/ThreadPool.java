/*
 * Copyright (c) 2018 Baidu, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.shanjiancaofu.study.threadpool;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Since {@linkplain java.util.concurrent.ExecutorService ExecutorService} is a
 * bit slow, we have to invent some wheels here.
 * <p>
 * NOT implement the {@linkplain java.util.concurrent.Executor Executor}
 * interface unless we see the necessity
 *
 * @author Zhangyi Chen (chenzhangyi01@baidu.com)
 * @update Wenwei hu (huwenwei@baidu.com)
 */
public final class ThreadPool {
	private static final int DEFAULT_QUEUE_SIZE = 1024;

	// Stand alone lock
	private BoundedQueue<Runnable> produced;
	private BoundedQueue<Runnable> toConsume;
	private Lock consumerLock;
	private Lock producerLock;
	private Condition isProducerNotFullCondition;
	private Condition isProducerNotEmptyCondition;
	private ArrayList<Thread> threads;

	private volatile boolean stopped;

	public ThreadPool(int initialThreadNum, ThreadFactory threadFactory) {
		this(initialThreadNum, threadFactory, 0);
	}

	public ThreadPool(int initialThreadNum, ThreadFactory threadFactory, int queueSize) {
		if (initialThreadNum <= 0) {
			throw new IllegalArgumentException("initialThreadNum=" + initialThreadNum + " should be positive");
		}
		threads = new ArrayList<Thread>(initialThreadNum);
		stopped = false;

		if (queueSize <= 0) {
			queueSize = DEFAULT_QUEUE_SIZE;
		}
		produced = new BoundedQueue<Runnable>(queueSize);
		toConsume = new BoundedQueue<Runnable>(queueSize);
		consumerLock = new ReentrantLock();
		producerLock = new ReentrantLock();
		isProducerNotEmptyCondition = producerLock.newCondition();
		isProducerNotFullCondition = producerLock.newCondition();
		// Start working threads at last, don't put any code after, or there
		// will be race condition
		for (int i = 0; i < initialThreadNum; ++i) {
			Thread tr = threadFactory.newThread(new Runnable() {
				@Override
				public void run() {
					consume();
				}
			});
			tr.start();
			threads.add(tr);
		}
	}

	private void consume() {
		while (true) {
			Runnable task = null;
			while (true) {
				consumerLock.lock();
				try {
					// 消费者队列不是空
					if (!toConsume.isEmpty()) {
						task = toConsume.pop();
						break;
					}
				} finally {
					consumerLock.unlock();
				}

				// 生产者不为空的时候, 交换队列
				producerLock.lock();
				try {
					while (!stopped && produced.isEmpty()) {
						try {
							// 生成者不为空, 有生产的
							isProducerNotEmptyCondition.await();
						} catch (InterruptedException ex) {
							// ignore
						}
					}
					if (!produced.isEmpty()) {
						if (produced.isFull()) {
							isProducerNotFullCondition.signalAll();
						}
						consumerLock.lock();
						try {
							BoundedQueue<Runnable> tmp = produced;
							produced = toConsume;
							toConsume = tmp;
						} finally {
							consumerLock.unlock();
						}
					} else {
						// stopped must be true
						break;
					}
				} finally {
					producerLock.unlock();
				}
			}
			if (task != null) {
				task.run();
			} else {
				// The thread pool was shut down
				break;
			}
		}
	}

	public void stop() {
		stopped = true;
		producerLock.lock();
		try {
			isProducerNotEmptyCondition.signalAll();
			isProducerNotFullCondition.signalAll();
		} finally {
			producerLock.unlock();
		}
	}

	public void join() {
		synchronized (threads) {
			for (Thread tr : threads) {
				try {
					tr.join();
				} catch (InterruptedException e) {
					// pass
				}
			}
			threads.clear();
		}
	}

	public boolean submit(Runnable task) {
		Runnable[] tasks = {task};
		return submit(tasks, 0, 1) == 1;
	}

	public long submit(Runnable[] tasks, int offset, int len) {
		int cur = offset;
		int end = offset + len;
		while (!stopped && cur < end) {
			producerLock.lock();
			try {
				while (produced.isFull()) {
					try {
						// 执行等待
						isProducerNotFullCondition.await();
					} catch (InterruptedException ex) {
						// ignore
					}
				}
				int toProduce = Math.min(produced.remainingCapacity(), end - cur);
				if (toProduce > 0) {
					boolean wasEmpty = produced.isEmpty();
					produced.addAll(tasks, cur, toProduce);
					// 唤醒所有的等待线程
					if (wasEmpty) {
						isProducerNotEmptyCondition.signalAll();
					}
				}
				cur += toProduce;
			} finally {
				producerLock.unlock();
			}
		}
		return cur - offset;
	}


	public StatInfo getStatInfo() {
		StatInfo statInfo = new StatInfo();
		statInfo.setThreadNum(threads.size());
		statInfo.setDefaultQueueCapacity(DEFAULT_QUEUE_SIZE);
		statInfo.setProducerQueueSize(produced.size());
		statInfo.setConsumerQueueSize(toConsume.size());
		return statInfo;
	}


	public static class StatInfo {
		public int getThreadNum() {
			return threadNum;
		}

		public void setThreadNum(int threadNum) {
			this.threadNum = threadNum;
		}

		public int getDefaultQueueCapacity() {
			return defaultQueueCapacity;
		}

		public void setDefaultQueueCapacity(int defaultQueueCapacity) {
			this.defaultQueueCapacity = defaultQueueCapacity;
		}

		public int getProducerQueueSize() {
			return producerQueueSize;
		}

		public void setProducerQueueSize(int producerQueueSize) {
			this.producerQueueSize = producerQueueSize;
		}

		public int getConsumerQueueSize() {
			return consumerQueueSize;
		}

		public void setConsumerQueueSize(int consumerQueueSize) {
			this.consumerQueueSize = consumerQueueSize;
		}

		private int threadNum;
		private int defaultQueueCapacity;
		private int producerQueueSize;
		private int consumerQueueSize;
	}

	public boolean isStopped() {
		return stopped;
	}


	public static void calu() {
		int a = 1000;
		int b = 100000000 + a;
	}

}

