package com.quartztest.testdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//@MapperScan("com.quartztest.testdemo.mybaties")
@SpringBootApplication
public class TestdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestdemoApplication.class, args);
    }
}
