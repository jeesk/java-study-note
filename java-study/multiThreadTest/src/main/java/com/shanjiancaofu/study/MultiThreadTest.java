package com.shanjiancaofu.study;

import com.shanjiancaofu.study.threadpool.CustomThreadFactory;
import com.shanjiancaofu.study.threadpool.ThreadPool;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

public class MultiThreadTest {
	public static void main(String[] args) throws InterruptedException {
		int number = 100000;
		int theradNumber = 12;
		testBySingleThread(number, theradNumber);
		testByExcutors(number, theradNumber);
		testBySpringThreadPool(number, theradNumber);
		testThreadPoolBySelf(number, theradNumber);
		testForkJoin(number, theradNumber);
		testByMultiThread(number, theradNumber);
	}

	public static void testBySingleThread(int number, int theradNumber) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < number; i++) {
			Queue8 queue8 = new Queue8();
			queue8.check(0);
		}
		System.out.printf("cost: %sms ,test by single thread \n", (System.currentTimeMillis() - start));
	}

	public static void testByMultiThread(int number, int theradNumber) throws InterruptedException {
		long start = System.currentTimeMillis();
		CountDownLatch countDownLatch = new CountDownLatch(number);
		for (long i = 0; i < number; i++) {
			new Thread(() -> {
				Queue8 queue8 = new Queue8();
				queue8.check(0);
				countDownLatch.countDown();
			}).start();
		}
		countDownLatch.await();
		System.out.printf("cost: %sms ,test by multi thread \n", (System.currentTimeMillis() - start));
	}

	public static void testByExcutors(int number, int theradNumber) throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(theradNumber);
		CountDownLatch countDownLatch = new CountDownLatch(number);
		long start = System.currentTimeMillis();
		for (long i = 0; i < number; i++) {
			executorService.submit(new Runnable() {
				@Override
				public void run() {
					Queue8 queue8 = new Queue8();
					queue8.check(0);
					countDownLatch.countDown();
				}
			});
		}
		countDownLatch.await();
		executorService.shutdownNow();
		System.out.printf("cost: %sms ,test by multi executors \n", (System.currentTimeMillis() - start));
	}

	public static void testBySpringThreadPool(int number, int theradNumber) throws InterruptedException {
		CountDownLatch countDownLatch1 = new CountDownLatch(number);
		final ThreadPoolTaskExecutor masterPoolExecutor = new ThreadPoolTaskExecutor();
		masterPoolExecutor.setCorePoolSize(theradNumber);
		masterPoolExecutor.setMaxPoolSize(theradNumber);
		masterPoolExecutor.setThreadFactory(new CustomizableThreadFactory("masterPool"));
		masterPoolExecutor.initialize();
		long start = System.currentTimeMillis();
		for (int i = 0; i < number; i++) {
			masterPoolExecutor.submit(new Runnable() {
				@Override
				public void run() {
					Queue8 queue8 = new Queue8();
					queue8.check(0);
					countDownLatch1.countDown();
				}
			});
		}
		countDownLatch1.await();
		masterPoolExecutor.shutdown();
		System.out.printf("cost: %sms ,test by spring threadpool  \n", (System.currentTimeMillis() - start));
	}

	public static void testThreadPoolBySelf(int number, int theradNumber) throws InterruptedException {
		CountDownLatch countDownLatch1 = new CountDownLatch(number);
		ThreadPool threadPool = new ThreadPool(theradNumber, new CustomizableThreadFactory("masterPool"));
		long start = System.currentTimeMillis();
		for (int i = 0; i < number; i++) {
			threadPool.submit(() -> {
				Queue8 queue8 = new Queue8();
				queue8.check(0);
				countDownLatch1.countDown();
			});
		}
		countDownLatch1.await();
		threadPool.stop();
		System.out.printf("cost: %sms ,test by threadpool by self  \n", (System.currentTimeMillis() - start));
	}

	public static void testForkJoin(int number, int theradNumber) throws InterruptedException {

		ForkJoinPool forkJoinPool = new ForkJoinPool(theradNumber);
		CountDownLatch countDownLatch1 = new CountDownLatch(number);
		long start = System.currentTimeMillis();
		for (int i = 0; i < number; i++) {
			ForkJoinTask<?> adapt = ForkJoinTask.adapt(new Runnable() {
				@Override
				public void run() {
					Queue8 queue8 = new Queue8();
					queue8.check(0);
					countDownLatch1.countDown();

				}
			});
			forkJoinPool.invoke(adapt);
		}
		countDownLatch1.await();
		System.out.printf("cost: %sms ,test by testForkJoin \n", (System.currentTimeMillis() - start));
	}


}
