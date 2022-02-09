package com.shanjiancaofu.multischeduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * 配置任务队列线程池, 让任务准时执行, 不然task 会排队,造成串行执行核心配置的 TaskSchedulingProperties
 */
@SpringBootApplication
// 开启定时任务
@EnableScheduling
public class MultiSchedulerApplication {
	public static void main(String[] args) {
		SpringApplication.run(MultiSchedulerApplication.class, args);
	}

}
