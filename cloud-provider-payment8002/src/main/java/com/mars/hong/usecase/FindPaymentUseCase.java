package com.mars.hong.usecase;

import com.mars.hong.adapter.PaymentResponse;
import com.mars.hong.common.Result;
import com.mars.hong.entity.Payment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@AllArgsConstructor
@Component
public class FindPaymentUseCase {
    private final PaymentRepository paymentRepository;

    public Result<PaymentResponse> execute(FindPaymentInput findPaymentInput) {
        Long id = findPaymentInput.getId();
        Optional<Payment> result = this.paymentRepository.findProductBy(id);
        if (result.isPresent()) {
            return new Result<>(new PaymentResponse(id, result.get().getSerial()));
        } else {
            throw new RuntimeException("Given invalid identity");
        }
    }
}
