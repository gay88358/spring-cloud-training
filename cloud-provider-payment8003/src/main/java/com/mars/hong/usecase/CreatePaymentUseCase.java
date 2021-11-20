package com.mars.hong.usecase;

import com.mars.hong.common.Result;
import com.mars.hong.entity.Payment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreatePaymentUseCase {
    private final PaymentRepository paymentRepository;

    public Result<Long> execute(CreatePaymentInput createPaymentInput) {
        Payment payment = new Payment(createPaymentInput.getSerial());
        this.paymentRepository.save(payment);
        return new Result<>(payment.getId());
    }
}
