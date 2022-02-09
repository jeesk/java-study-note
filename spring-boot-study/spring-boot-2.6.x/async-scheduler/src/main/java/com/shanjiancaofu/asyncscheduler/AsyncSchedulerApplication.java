package com.shanjiancaofu.asyncscheduler;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 异步定时任务 , 通过@Async方法将任务 提交到 task任务池, task任务池见配置类: TaskExecutionProperties执行
 */
@SpringBootApplication
@EnableAsync
@EnableScheduling
public class AsyncSchedulerApplication {
	public static void main(String[] args) {
		SpringApplication.run(AsyncSchedulerApplication.class, args);
	}
}
