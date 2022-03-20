package com.shanjiancaofu.jvmstudy;

import java.util.concurrent.CountDownLatch;

/**
 * -XX:+/-UseTLAB  减少指针碰撞
 */
public class TlABTest {
	Integer count = 0;

	public static void main(String[] args) throws InterruptedException {
		TlABTest tlABTest = new TlABTest();
		CountDownLatch countDownLatch1 = new CountDownLatch(10000);
		CountDownLatch countDownLatch2 = new CountDownLatch(1);
		for (int i = 0; i < 10000; i++) {
			new Thread(() -> {
				try {
					countDownLatch2.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				tlABTest.count++;
				countDownLatch1.countDown();
			}).start();
		}
		countDownLatch2.countDown();
		countDownLatch1.await();
		System.out.println(tlABTest.count);

	}
}
