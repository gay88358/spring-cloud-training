package com.mars.hong;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.logging.Logger;

@RestController
@Slf4j
public class PaymentController {

    private final Logger logger = Logger.getLogger(PaymentService.class.getName());
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo(@PathVariable("id") Integer id) {
        String result = this.paymentService.paymentInfo(id);
        logger.info("****result: " + result);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentTimeout(Integer id) {
        String result = this.paymentService.paymentTimeout(id);

        logger.info("****result: " + result);
        return result;
    }

    @GetMapping("/payment/hystrix/circuitBreaker/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Long id) {
        return this.paymentService.paymentCircuitBreaker(id);
    }
}