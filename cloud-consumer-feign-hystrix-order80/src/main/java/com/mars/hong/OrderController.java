package com.mars.hong;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@DefaultProperties(defaultFallback = "globalPaymentTimeoutHandler")
public class OrderController {
    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    @HystrixCommand
    String paymentInfo(@PathVariable("id") Integer id) {
        int a = 10 / 0;
        return this.paymentService.paymentInfo(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    String paymentTimeout(@PathVariable("id") Integer id) {
        return this.paymentService.paymentTimeout(id);
    }

    public String paymentTimeoutHandler(Integer id) {
        return "Thread: " + Thread.currentThread().getName() + "    consumer80" + id + "QQ";
    }

    public String globalPaymentTimeoutHandler() {
        return "Thread: " + Thread.currentThread().getName() + "    global consumer80";
    }

}
