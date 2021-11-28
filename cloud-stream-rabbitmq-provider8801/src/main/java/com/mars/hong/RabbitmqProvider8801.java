package com.mars.hong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RabbitmqProvider8801 {
    public static void main(String[] args) {
        SpringApplication.run(RabbitmqProvider8801.class, args);
    }
}
