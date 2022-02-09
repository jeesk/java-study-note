package com.shanjiancaofu.study;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 该应用展示了h2 database(tcp) + mybatis-plus的用法
 * 本地运行一个h2 database 请看lib 目录的readme.md 文件
 */
@SpringBootApplication
@MapperScan("com.shanjiancaofu.study.mapper")
public class H2DatabaseTcpApplication {
    public static void main(String[] args) {
        SpringApplication.run(H2DatabaseTcpApplication.class, args);
    }
}
