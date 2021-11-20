package com.mars.hong;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
    private final RestTemplate restTemplate;
    private static final String paymentServiceUrl = "http://cloud-payment-service";
    @Value("${server.port}")
    private String ip;

    public OrderController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping(value = "/consumer/payments/zk")
    public String paymentZk() {
        return this.restTemplate.getForObject(
                paymentServiceUrl + "/payments/zk",
                String.class
        );
    }
}
