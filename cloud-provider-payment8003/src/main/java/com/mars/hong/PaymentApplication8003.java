package com.mars.hong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PaymentApplication8003 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication8003.class, args);
    }
}
