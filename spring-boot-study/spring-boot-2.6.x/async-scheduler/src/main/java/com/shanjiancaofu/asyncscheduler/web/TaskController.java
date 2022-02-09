package com.shanjiancaofu.asyncscheduler.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TaskController {
	@GetMapping("index")
	public String index() {
		Thread thread = Thread.currentThread();
		String desc = String.format("线程名: %s 线程id %s 当前时间 %s ", thread.getName(), thread.getId(), System.currentTimeMillis());
		return desc;
	}
}
