package com.ky.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.ky.dao.mapper")
@ComponentScan("com.ky")
@EnableTransactionManagement    //开启事务
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}