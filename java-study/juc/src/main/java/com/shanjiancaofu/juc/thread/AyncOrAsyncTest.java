package com.shanjiancaofu.juc.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AyncOrAsyncTest {
	static ExecutorService executorService = Executors.newCachedThreadPool();

	public static void main(String[] args) throws InterruptedException {
		long start = System.currentTimeMillis();
		async("听歌");
		System.out.println("听歌异步调用花费时间:" + (System.currentTimeMillis() - start) + "ms");
		doSomeThing("吃饭");
		System.out.println("吃饭和听歌一共花费时间" + (System.currentTimeMillis() - start) + "ms");
		start = System.currentTimeMillis();
		sync("听歌");
		doSomeThing("吃饭");
		System.out.println("吃饭和听歌一共花费时间" + (System.currentTimeMillis() - start) + "ms");
	}


	public static Future<String> async(final String str) {

		// 向线程池提交并行任务
		return executorService.submit(() -> {
			// 以异步的方式在新的线程中执行其他任务
			System.out.println("开始:" + str);
			doSomeThing(str);
			return str;
		});
	}

	public static String sync(String str) throws InterruptedException {
		return doSomeThing(str);
	}

	public static String doSomeThing(String str) throws InterruptedException {
		System.out.println(str);
		Thread.sleep(2000);
		return str;

	}

}
