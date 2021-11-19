package com.mars.hong.usecase;

import com.mars.hong.entity.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository {
    void save(Payment payment);
    List<Payment> findAllProducts();
    Optional<Payment> findProductBy(Long id);
}
