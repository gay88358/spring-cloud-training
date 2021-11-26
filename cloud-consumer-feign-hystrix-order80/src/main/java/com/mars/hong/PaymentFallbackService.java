package com.mars.hong;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService{
    @Override
    public String paymentInfo(Integer id) {
        return "fallback for paymentInfo";
    }

    @Override
    public String paymentTimeout(Integer id) {
        return "fallback for paymentTimeout";
    }
}
