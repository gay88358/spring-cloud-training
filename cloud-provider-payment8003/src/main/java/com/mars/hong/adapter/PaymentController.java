package com.mars.hong.adapter;

import com.mars.hong.common.Envelope;
import com.mars.hong.common.Result;
import com.mars.hong.usecase.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class PaymentController {
    private final CreatePaymentUseCase createPaymentUseCase;
    private final FindPaymentUseCase findPaymentUseCase;
    private final FindAllPaymentUseCase findAllPaymentUseCase;

    @Autowired
    public PaymentController(CreatePaymentUseCase createPaymentUseCase, FindPaymentUseCase findPaymentUseCase, FindAllPaymentUseCase findAllPaymentUseCase) {
        this.createPaymentUseCase = createPaymentUseCase;
        this.findAllPaymentUseCase = findAllPaymentUseCase;
        this.findPaymentUseCase = findPaymentUseCase;
    }

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payments")
    public Envelope<Long> createPayment() {
        Result<Long> result = this.createPaymentUseCase.execute(new CreatePaymentInput("123123"));
        return new Envelope<>(200, String.format("create success, server port: %s", serverPort), result.getValue());
    }

    @GetMapping("/payments/{id}")
    public Envelope<PaymentResponse> findPayment(@PathVariable Long id) {
        Result<PaymentResponse> result = this.findPaymentUseCase.execute(new FindPaymentInput(id));
        return new Envelope<>(200, String.format("find payment success, server port: %s", serverPort), result.getValue());
    }

    @GetMapping("/payments")
    public Envelope<List<PaymentResponse>> findAllPayment() {
        Result<List<PaymentResponse>> result = this.findAllPaymentUseCase
                .execute(new FindAllPaymentInput());
        return new Envelope<>(200, String.format("find all payment success, server port: %s", serverPort), result.getValue());
    }

    @GetMapping("/payments/lb")
    public String getPaymentLB() {
        return serverPort;
    }


    @GetMapping("/payments/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.serverPort;
    }
}
