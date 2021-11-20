package com.mars.hong.adapter;

import com.mars.hong.entity.Payment;
import com.mars.hong.usecase.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class JPAPaymentRepository implements PaymentRepository {
    private final PaymentRepositoryPeer paymentRepositoryPeer;

    @Override
    public void save(Payment payment) {
        this.paymentRepositoryPeer.save(payment);
    }

    @Override
    public List<Payment> findAllProducts() {
        Iterable<Payment> payments = this.paymentRepositoryPeer
                .findAll();
        List<Payment> result = new ArrayList<>();
        payments.forEach(result::add);
        return result;
    }

    @Override
    public Optional<Payment> findProductBy(Long id) {
        return this.paymentRepositoryPeer.findById(id);
    }
}
