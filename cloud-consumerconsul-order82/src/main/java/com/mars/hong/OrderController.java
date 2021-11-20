package com.mars.hong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
    private final RestTemplate restTemplate;

    @Autowired
    public OrderController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @GetMapping("/consumer/payments/consul")
    String paymentConsul() {
        return this.restTemplate.getForObject(
                "http://cloud-payment-service/payments/consul",
                String.class
        );
    }
}
