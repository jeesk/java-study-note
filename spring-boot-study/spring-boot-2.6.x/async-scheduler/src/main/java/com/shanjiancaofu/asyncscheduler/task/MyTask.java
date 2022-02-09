package com.shanjiancaofu.asyncscheduler.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 两个任务不能单独同时执行, 只能单独执行一个任务(因为sceduler只有一个线程)
 */
@Component
public class MyTask {
	@Scheduled(cron = "0/5 * * * * ? ")
	@Async
	public void task1() throws InterruptedException {
		Thread thread = Thread.currentThread();
		String desc = String.format("线程名: %s 线程id %s 当前时间 %s ", thread.getName(), thread.getId(), System.currentTimeMillis());
		System.out.println("task1 " + desc);
		Thread.sleep(10000);
	}

	@Scheduled(cron = "0/5 * * * * ? ")
	@Async
	public void task2() throws InterruptedException {
		Thread thread = Thread.currentThread();
		String desc = String.format("线程名: %s 线程id %s 当前时间 %s ", thread.getName(), thread.getId(), System.currentTimeMillis());
		System.out.println("task2 " + desc);
		Thread.sleep(10000);
	}

	@Scheduled(cron = "0/5 * * * * ? ")
	@Async
	public void task3() throws InterruptedException {
		Thread thread = Thread.currentThread();
		String desc = String.format("线程名: %s 线程id %s 当前时间 %s ", thread.getName(), thread.getId(), System.currentTimeMillis());
		System.out.println("task3 " + desc);
		Thread.sleep(10000);
	}

}
