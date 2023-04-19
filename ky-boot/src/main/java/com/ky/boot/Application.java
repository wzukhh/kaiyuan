package com.ky.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.ky.dao.mapper")
@ComponentScan("com.ky")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}