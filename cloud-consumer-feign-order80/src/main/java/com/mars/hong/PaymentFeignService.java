package com.mars.hong;

import com.mars.hong.common.Envelope;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping("/payments/{id}")
    Envelope<Payment> findPayment(@PathVariable("id") Long id);

    @GetMapping("/payments/feign/timeout")
    String paymentFeignTimeout();
}