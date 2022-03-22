package com.shanjiancaofu.juc.thread;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

public class BlockOrNonBlockTest {
	public static void main(String[] args) throws InterruptedException {
		long start = System.currentTimeMillis();
		testNonBlock();
		System.out.println("非阻塞队列消耗时间:" + (System.currentTimeMillis() - start));
		start = System.currentTimeMillis();
		testBlock();
		System.out.println("阻塞队列消耗时间:" + (System.currentTimeMillis() - start));
	}

	public static void testBlock() throws InterruptedException {
		// 阻塞队列
		ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue(1);
		arrayBlockingQueue.poll(1, TimeUnit.SECONDS);

	}

	public static void testNonBlock() {
		// 非阻塞队列
		ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
		queue.poll();
	}
}
