package com.mars.hong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RabbitmqConsumer8803 {
    public static void main(String[] args) {
        SpringApplication.run(RabbitmqConsumer8803.class, args);
    }
}
