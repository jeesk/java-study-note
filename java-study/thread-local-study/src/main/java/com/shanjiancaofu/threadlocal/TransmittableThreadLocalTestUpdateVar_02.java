package com.shanjiancaofu.threadlocal;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 池化复用的情况下， 修改了ThreadLocal信息，无法感知
 *
 */
public class TransmittableThreadLocalTestUpdateVar_02 {


	static final ThreadLocal<String> local = new TransmittableThreadLocal<>();

	public static void main(String[] args) throws InterruptedException {
		test1();
	}

	public static void test1() throws InterruptedException {
		String uuid = String.valueOf(new Random().nextFloat());
		ExecutorService executorService1 = TtlExecutors.getTtlExecutorService(Executors.newFixedThreadPool(1));
		CountDownLatch countDownLatch1 = new CountDownLatch(1);
		CountDownLatch countDownLatch2 = new CountDownLatch(1);
		local.set(uuid);
		executorService1.submit(() -> {
			System.out.printf("Thread id %s value: %s%n", Thread.currentThread().getId(), local.get());
			countDownLatch1.countDown();
		});
		countDownLatch1.await();
		local.set("change Var");
		executorService1.submit(new Runnable() {
			@Override
			public void run() {
				System.out.printf("Thread id %s value: %s%n", Thread.currentThread().getId(), local.get());
				countDownLatch2.countDown();
			}
		});
		countDownLatch2.await();
		System.out.printf("Thread id %s value: %s%n", Thread.currentThread().getId(), local.get());
		executorService1.shutdownNow();
	}

}
