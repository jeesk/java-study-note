package com.shanjiancaofu.threadlocal;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * var crosses thread  by threadlocal is unverified
 * 跨线程ThreadLocal是无效的
 */
public class ThreadLocalTestGetVar_01 {


	public static void main(String[] args) throws InterruptedException {
		test2();
	}

	public static void test2() throws InterruptedException {
		ThreadLocal<String> local = new ThreadLocal<>();
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		String uuid = String.valueOf(new Random().nextFloat());
		local.set(uuid);
		executorService.submit(() -> {
			System.out.printf("Thread id %s value: %s%n", Thread.currentThread().getId(), local.get());
		});
		Thread.sleep(2 * 1000);
		System.out.printf("Thread id %s value: %s%n", Thread.currentThread().getId(), local.get());
	}


}
