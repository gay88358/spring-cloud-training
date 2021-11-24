package com.mars.hong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrderApplicationOpenFeign80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplicationOpenFeign80.class, args);
    }
}
