package com.mars.hong.usecase;

import com.mars.hong.common.Result;
import com.mars.hong.adapter.PaymentResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class FindAllPaymentUseCase {
    private final PaymentRepository paymentRepository;

    public Result<List<PaymentResponse>> execute(FindAllPaymentInput input) {
        List<PaymentResponse> result = this.paymentRepository
                .findAllProducts()
                .stream()
                .map(p -> new PaymentResponse(p.getId(), p.getSerial()))
                .collect(Collectors.toList());
        return new Result<>(result);
    }
}
