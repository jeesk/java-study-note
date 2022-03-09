package com.shanjiancaofu.async.web;

import com.shanjiancaofu.async.service.HelloService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

/**
 * Calable 异步执行方法, 并且等待返回,  相对于Async 方法来说, Spring 会等工作线程执行完成后, 才返回给客户端
 */
@RestController
@RequestMapping
public class CallabledCallController {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CallabledCallController.class);

	@Autowired
	private HelloService hello;

	/**
	 * 异步调用restful
	 * 当controller返回值是Callable的时候，springmvc就会启动一个线程将Callable交给TaskExecutor去处理
	 * 然后DispatcherServlet还有所有的spring拦截器都退出主线程，然后把response保持打开的状态
	 * 当Callable执行结束之后，springmvc就会重新启动分配一个request请求，然后DispatcherServlet就重新
	 * 调用和处理Callable异步执行的返回结果， 然后返回视图
	 *
	 * @return
	 */
	@GetMapping("/hello")
	public Callable<String> helloController() {

		//                 : http-nio-8080-exec-10 进入helloController方法
		//                : http-nio-8080-exec-10 从helloController方法返回
		//               : MvcAsync4 进入call方法
		//               : MvcAsync4 从helloService方法返回
		logger.info(Thread.currentThread().getName() + " 进入helloController方法");

		Callable<String> callable = () -> {
			logger.info(Thread.currentThread().getName() + " 进入call方法");
			String say = hello.sayHello();
			hello.asyncSayHello();
			logger.info(Thread.currentThread().getName() + " 从helloService方法返回");
			return say;
		};
		logger.info(Thread.currentThread().getName() + " 从helloController方法返回");
		return callable;
	}


}
