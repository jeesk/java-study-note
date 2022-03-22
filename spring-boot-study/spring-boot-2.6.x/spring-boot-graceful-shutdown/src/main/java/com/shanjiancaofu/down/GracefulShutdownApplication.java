package com.shanjiancaofu.down;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * spring boot 配置优雅停机
 */
@SpringBootApplication
@RestController
@RequestMapping
public class GracefulShutdownApplication {
    public static void main(String[] args) {
        SpringApplication.run(GracefulShutdownApplication.class, args);
    }

    @GetMapping("process")
    public String process() throws InterruptedException {
        Thread.sleep(25 * 2000);
        return "successd";
    }


}
