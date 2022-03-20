package com.shanjiancaofu.async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
// 开启异步处理

@EnableAsync
public class AsyncReqeustApplication {
	public static void main(String[] args) {
		SpringApplication.run(AsyncReqeustApplication.class, args);
	}

}


