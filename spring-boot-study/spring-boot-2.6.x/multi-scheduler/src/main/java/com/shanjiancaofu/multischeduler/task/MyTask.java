package com.shanjiancaofu.multischeduler.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 配置
 * spring:
 * task:
 * scheduling:
 * thread-name-prefix: "scheduling-"
 * pool:
 * size: 5
 * 可以看到任务的线程都是 scheduling 线程池
 */
@Component
public class MyTask {
	@Scheduled(cron = "0/5 * * * * ? ")
	public void task1() throws InterruptedException {
		Thread thread = Thread.currentThread();
		String desc = String.format("线程名: %s 线程id %s 当前时间 %s ", thread.getName(), thread.getId(), System.currentTimeMillis());
		System.out.println("task1 " + desc);
		Thread.sleep(10000);
	}

	@Scheduled(cron = "0/5 * * * * ? ")
	public void task2() throws InterruptedException {
		Thread thread = Thread.currentThread();
		String desc = String.format("线程名: %s 线程id %s 当前时间 %s ", thread.getName(), thread.getId(), System.currentTimeMillis());
		System.out.println("task2 " + desc);
		Thread.sleep(10000);
	}

	@Scheduled(cron = "0/5 * * * * ? ")
	public void task3() throws InterruptedException {
		Thread thread = Thread.currentThread();
		String desc = String.format("线程名: %s 线程id %s 当前时间 %s ", thread.getName(), thread.getId(), System.currentTimeMillis());
		System.out.println("task3 " + desc);
		Thread.sleep(10000);
	}

	@Scheduled(cron = "0/5 * * * * ? ")
	public void task4() throws InterruptedException {
		Thread thread = Thread.currentThread();
		String desc = String.format("线程名: %s 线程id %s 当前时间 %s ", thread.getName(), thread.getId(), System.currentTimeMillis());
		System.out.println("task4 " + desc);
		Thread.sleep(10000);
	}
}
