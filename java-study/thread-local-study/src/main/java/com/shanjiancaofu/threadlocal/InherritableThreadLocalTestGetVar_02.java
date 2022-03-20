package com.shanjiancaofu.threadlocal;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Var of crosses thread  by threadlocal is verified
 * InheritableThreadLocal 变量跨线程就有效的
 */
public class InherritableThreadLocalTestGetVar_02 {


	public static void main(String[] args) throws InterruptedException {
		test1();
	}

	public static void test1() throws InterruptedException {
		ThreadLocal<String> local = new InheritableThreadLocal<>();
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
