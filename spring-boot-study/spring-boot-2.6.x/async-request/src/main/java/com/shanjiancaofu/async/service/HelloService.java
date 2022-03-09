package com.shanjiancaofu.async.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
@Slf4j
public class HelloService {

	ExecutorService executorService = Executors.newFixedThreadPool(10);


	@Autowired
	private ThreadPoolTaskExecutor threadPoolExecutor;


	public String sayHello() {

		log.info(Thread.currentThread().getName() + " sayHello");
		return "Say hello ";
	}

	@Async
	public String asyncSayHello() {
		log.info(Thread.currentThread().getName() + " asyncSayHello");
		RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
		String abcStr = null;
		if (requestAttributes != null) {
			ServletRequestAttributes requestAttributes1 = (ServletRequestAttributes) requestAttributes;
			abcStr = requestAttributes1.getRequest().getHeader("abc");
			System.out.println(abcStr);
		}
		String finalAbcStr = abcStr;
		threadPoolExecutor.submit(new Runnable() {
			@Override
			public void run() {
				RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
				if (requestAttributes != null) {
					ServletRequestAttributes requestAttributes1 = (ServletRequestAttributes) requestAttributes;
					String abc = requestAttributes1.getRequest().getHeader("abc");
					System.out.println(abc + ":" + finalAbcStr);
				}
			}
		});
		new Thread(new Runnable() {
			@Override
			public void run() {
				RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
				if (requestAttributes != null) {
					ServletRequestAttributes requestAttributes1 = (ServletRequestAttributes) requestAttributes;
					String abc = requestAttributes1.getRequest().getHeader("abc");
					System.out.println(abc + ":" + finalAbcStr);
				}
			}
		}).start();

		executorService.submit(new Runnable() {
			@Override
			public void run() {
				RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
				if (requestAttributes != null) {
					ServletRequestAttributes requestAttributes1 = (ServletRequestAttributes) requestAttributes;
					String abc = requestAttributes1.getRequest().getHeader("abc");
					System.out.println(abc + ":" + finalAbcStr);
				}
				threadPoolExecutor.submit(new Runnable() {
					@Override
					public void run() {
						RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
						if (requestAttributes != null) {
							ServletRequestAttributes requestAttributes1 = (ServletRequestAttributes) requestAttributes;
							String abc = requestAttributes1.getRequest().getHeader("abc");
							System.out.println(abc + ":" + finalAbcStr);
						}
					}
				});

			}
		});
		return "Say hello ";
	}
}
