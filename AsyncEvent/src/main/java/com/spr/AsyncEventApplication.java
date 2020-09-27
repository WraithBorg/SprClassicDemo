package com.spr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class AsyncEventApplication {
    public static void main(String[] args) {
        SpringApplication.run(AsyncEventApplication.class, args);
    }
}
