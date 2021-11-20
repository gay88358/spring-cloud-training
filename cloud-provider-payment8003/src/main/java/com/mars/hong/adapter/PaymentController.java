package com.mars.hong.adapter;

import com.mars.hong.common.Envelope;
import com.mars.hong.common.Result;
import com.mars.hong.usecase.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PaymentController {
    private final CreatePaymentUseCase createPaymentUseCase;
    private final FindPaymentUseCase findPaymentUseCase;
    private final FindAllPaymentUseCase findAllPaymentUseCase;

    @PostMapping("/payments")
    public Envelope<Long> createPayment() {
        Result<Long> result = this.createPaymentUseCase.execute(new CreatePaymentInput("123123"));
        return new Envelope<>(200, "create success", result.getValue());
    }

    @GetMapping("/payments/{id}")
    public Envelope<PaymentResponse> findPayment(@PathVariable Long id) {
        Result<PaymentResponse> result = this.findPaymentUseCase.execute(new FindPaymentInput(id));
        return new Envelope<>(200, "find payment success", result.getValue());
    }

    @GetMapping("/payments")
    public Envelope<List<PaymentResponse>> findAllPayment() {
        Result<List<PaymentResponse>> result = this.findAllPaymentUseCase
                .execute(new FindAllPaymentInput());
        return new Envelope<>(200, "find all payment success", result.getValue());
    }
}
