package com.mars.hong;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String ip;

    @GetMapping("/payments/consul")
    String paymentConsul() {
        return "spring cloud consul payment, server port is: " + ip + " " + UUID.randomUUID().toString();
    }
}
