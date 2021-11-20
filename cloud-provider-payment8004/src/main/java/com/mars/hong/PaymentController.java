package com.mars.hong;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentController {
    @Value("${server.port}")
    private String ip;

    @GetMapping(value = "/payments/zk")
    public String paymentZk() {
        return "spring cloud with zookeeper: " + ip + UUID.randomUUID().toString();
    }
}
