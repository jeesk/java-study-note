package com.shanjiancaofu.async.web;

import com.shanjiancaofu.async.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.WebAsyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeoutException;

@RestController
public class WebAsyncTaskController_03 {

	private static final Logger logger = LoggerFactory.getLogger(WebAsyncTaskController_03.class);

	@Autowired
	private HelloService hello;

	/**
	 * 带超时时间的异步请求 通过WebAsyncTask自定义客户端超时间
	 * 支持超时和完成的回调函数
	 *
	 * @return
	 */
	@GetMapping("/world")
	public WebAsyncTask<String> worldController() {
		logger.info(Thread.currentThread().getName() + " 进入helloController方法");

		// 3s钟没返回，则认为超时
		WebAsyncTask<String> webAsyncTask = new WebAsyncTask<>(3000, () -> {
			logger.info(Thread.currentThread().getName() + " 进入call方法");
			String say = hello.sayHello();
			logger.info(Thread.currentThread().getName() + " 从helloService方法返回");
			return say;
		});
		logger.info(Thread.currentThread().getName() + " 从helloController方法返回");

		webAsyncTask.onCompletion(() -> logger.info(Thread.currentThread().getName() + " 执行完毕"));

		webAsyncTask.onTimeout(() -> {
			logger.info(Thread.currentThread().getName() + " onTimeout");
			// 超时的时候，直接抛异常，让外层统一处理超时异常
			throw new TimeoutException("调用超时");
		});
		return webAsyncTask;
	}

	/**
	 * 异步调用，异常处理，详细的处理流程见MyExceptionHandler类
	 *
	 * @return
	 */
	@GetMapping("/exception")
	public WebAsyncTask<String> exceptionController() {
		logger.info(Thread.currentThread().getName() + " 进入helloController方法");
		Callable<String> callable = new Callable<String>() {

			@Override
			public String call() throws Exception {
				logger.info(Thread.currentThread().getName() + " 进入call方法");
				throw new TimeoutException("调用超时!");
			}
		};
		logger.info(Thread.currentThread().getName() + " 从helloController方法返回");
		return new WebAsyncTask<>(20000, callable);
	}

}
