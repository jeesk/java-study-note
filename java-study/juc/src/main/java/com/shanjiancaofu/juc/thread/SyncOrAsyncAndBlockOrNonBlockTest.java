package com.shanjiancaofu.juc.thread;


import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.concurrent.*;

/**
 * 所谓同步，就是在发出一个调用时，在没有得到结果之前， 该调用就不返回。
 * 异步则是反，调用在发出之后，这个调用就直接返回了，所以没有返回结果
 * <p>
 * 请求不能立即得到应答，需要等待，那就是阻塞；否则可以理解为非阻塞。
 * <p>
 * 异步的情况下是没有阻塞和非阻塞之分的。
 */
public class SyncOrAsyncAndBlockOrNonBlockTest {
	public static void main(String[] args) throws InterruptedException, ExecutionException {


		long start = System.currentTimeMillis();
		Future<String> future = async("听歌");
		// 这里可以做一些事
		doSomeThing("吃饭");
		System.out.println("吃饭和听歌一共花费时间" + (System.currentTimeMillis() - start) + "ms");
		start = System.currentTimeMillis();
		sync("听歌");
		doSomeThing("吃饭");
		System.out.println("同步吃饭和听歌一共花费时间" + (System.currentTimeMillis() - start) + "ms");


		//testBlock();
		//testNonBlock();
		// 通过这上面2个测试方法可以发现，非阻塞队列直接告诉你队列满了，而阻塞队列在插入第二个元素的时候会将线程挂起什么事都不能做。

	}

	public static void doSomeThing(String str) throws InterruptedException {
		System.out.println(str);
		Thread.sleep(5000);
	}

	public static void testBlock() throws InterruptedException {
		ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(1);
		arrayBlockingQueue.put(1);
		arrayBlockingQueue.put(2);
		System.out.println("完成放入数据");
		// 这个阻塞队列目前已经满了， 如果不出队列， 永远会阻塞
	}

	/**
	 * 异步执行
	 *
	 * @param str
	 */
	public static Future<String> async(final String str) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		// 向线程池提交并行任务
		return executorService.submit(() -> {
			// 以异步的方式在新的线程中执行其他任务
			Thread.sleep(5000);
			System.out.println(str);
			return str;
		});
	}


	public static void testNonBlock() {
		// 非阻塞队列
		ArrayQueue<Object> queue = new ArrayQueue<>(1);
		queue.add(1);
		try {
			queue.add(2);
			System.out.println("完成放入数据");
		} catch (Exception e) {
			System.out.println(e);
		}
	}




	public static String sync(String str) throws InterruptedException {
		Thread.sleep(5000);
		System.out.println(str);
		return str;
	}

}
