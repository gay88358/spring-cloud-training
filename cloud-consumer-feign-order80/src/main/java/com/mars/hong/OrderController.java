package com.mars.hong;

import com.mars.hong.common.Envelope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final PaymentFeignService paymentFeignService;

    @Autowired
    public OrderController(PaymentFeignService paymentFeignService) {
        this.paymentFeignService = paymentFeignService;
    }

    @GetMapping("/payments/{id}")
    public Envelope<Payment> findPayment(@PathVariable("id") Long id) {
        return this.paymentFeignService.findPayment(id);
    }

    @GetMapping("/consumer/payments/feign/timeout")
    public String paymentFeignTimeout() {
        return this.paymentFeignService.paymentFeignTimeout();
    }


}
