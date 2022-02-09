package com.shanjiancaofu.async.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskDecorator;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.async.TimeoutCallableProcessingInterceptor;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@Slf4j
public class ServiceSpringConfig extends WebMvcConfigurerAdapter implements WebMvcConfigurer {

	@Bean
	public TaskDecorator taskDecorator() {
		return runnable -> {
			RequestAttributes context = RequestContextHolder.currentRequestAttributes();
			return () -> {
				try {
					RequestContextHolder.setRequestAttributes(context);
					runnable.run();
				} finally {
					RequestContextHolder.resetRequestAttributes();
				}
			};
		};
	}

	@Bean
	public TimeoutCallableProcessingInterceptor timeoutCallableProcessingInterceptor() {
		return new TimeoutCallableProcessingInterceptor();
	}

}
