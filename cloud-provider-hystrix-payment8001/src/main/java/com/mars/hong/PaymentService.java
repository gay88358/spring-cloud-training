package com.mars.hong;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {
    public String paymentInfo(Integer id) {
        return "Thread: " + Thread.currentThread().getName() + "payment ok" + id + "^^";
    }

    @HystrixCommand(fallbackMethod = "paymentTimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "7000")
    })
    public String paymentTimeout(Integer id) {
//        int age = 10 / 0;

        int times = 5;
        try {
            TimeUnit.SECONDS.sleep(times);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Thread: " + Thread.currentThread().getName() + "    paymentTimeout ok" + id + "^^" + "three seconds";
    }

    public String paymentTimeoutHandler(Integer id) {
        return "Thread: " + Thread.currentThread().getName() + "    paymentTimeoutHandler ok" + id + "QQ";
    }


    @HystrixCommand(
            fallbackMethod = "paymentCircuitBreakerFallback",
            commandProperties = {
                    @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
            }
    )
    public String paymentCircuitBreaker(Long id) {
        if (id < 0) {
            throw new RuntimeException("paymentCircuitBreaker");
        }
        String serialNumber = UUID.randomUUID().toString();
        return Thread.currentThread().getName() + " invoke success: " + serialNumber;
    }

    public String paymentCircuitBreakerFallback(Long id) {
        return " Id can't be negative";
    }
}
