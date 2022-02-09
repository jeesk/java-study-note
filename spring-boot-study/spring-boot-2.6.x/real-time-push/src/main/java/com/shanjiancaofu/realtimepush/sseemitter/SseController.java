package com.shanjiancaofu.realtimepush.sseemitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
public class SseController {

	@Autowired
	ApplicationContext applicationContext;
	@Autowired
    PayCompletedListener payCompletedListener;

	@GetMapping("/push") // 第一步
	public SseEmitter push(@RequestParam Long payRecordId) {
		// SseEmitter 是流式处理, 首先返回一个emiter , 再调用send() , 再调用 complete() 方法

		final SseEmitter emitter = new SseEmitter();
		// 异步推送事件. 当访问push 的时候, 阻塞.
		// 等到pay-callback 的时候都会调用,  然后获得响应
		try {
			payCompletedListener.addSseEmitters(payRecordId, emitter);
		} catch (Exception e) {
			emitter.completeWithError(e);
		}

		return emitter;
	}

	@GetMapping("/pay-callback") // 第二步
	public String payCallback(@RequestParam Long payRecordId) {
		applicationContext.publishEvent(new PayCompletedEvent(this, payRecordId));
		return "请到监听处查看消息";

	}

}
