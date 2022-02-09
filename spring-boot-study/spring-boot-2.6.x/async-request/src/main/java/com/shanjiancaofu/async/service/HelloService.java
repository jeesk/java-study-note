package com.shanjiancaofu.async.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class HelloService {
	public String sayHello() {
		return "Say hello ";
	}
}
