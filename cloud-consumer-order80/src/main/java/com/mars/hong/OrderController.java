package com.mars.hong;

import com.mars.hong.common.Envelope;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@AllArgsConstructor
public class OrderController {
    // remote resource
    private final RestTemplate restTemplate;


    @GetMapping("/consumer/payments/")
    public Envelope<Payment> createPayment() {

        Envelope<Long> envelope = restTemplate.postForObject(
                "http://localhost:8002/payments",
                null,
                Envelope.class
                );

        return restTemplate.getForObject(
                "http://localhost:8002/payments/" + envelope.getResource(),
                Envelope.class
                );
    }

}
