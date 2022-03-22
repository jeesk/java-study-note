package com.shanjiancaofu.study;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 该应用展示了h2 database(内存模式) + mybatis-plus的用法
 */
@SpringBootApplication
@MapperScan("com.shanjiancaofu.study.mapper")
public class H2DatabaseInMomoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(H2DatabaseInMomoryApplication.class, args);
    }
}
