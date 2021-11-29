package com.mars.hong;

import com.mars.hong.common.Envelope;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
@Slf4j
@AllArgsConstructor
public class OrderController {
    private final RestTemplate restTemplate;
    private final LoadBalancer loadBalancer;

    @GetMapping("/consumer/payments/")
    public Envelope<Payment> createPayment() {

        Envelope<Long> envelope = restTemplate.postForObject(
                "http://CLOUD-PAYMENT-SERVICE/payments",
                null,
                Envelope.class
                );

        return restTemplate.getForObject(
                "http://CLOUD-PAYMENT-SERVICE/payments/" + envelope.getResource(),
                Envelope.class
                );
    }

    @GetMapping("/consumer/payments/lb")
    public String getPaymentLB() {
        ServiceInstance serviceInstance = loadBalancer.instance("CLOUD-PAYMENT-SERVICE");
        URI uri = serviceInstance.getUri();

        return restTemplate.getForObject(
                uri + "payments/lb",
                String.class
        );
    }

    @GetMapping("/consumer/payments/zipkin")
    public String getPaymentZipKin() {
        ServiceInstance serviceInstance = loadBalancer.instance("CLOUD-PAYMENT-SERVICE");
        URI uri = serviceInstance.getUri();

        return restTemplate.getForObject(
                uri + "payments/zipkin",
                String.class
        );
    }
}
