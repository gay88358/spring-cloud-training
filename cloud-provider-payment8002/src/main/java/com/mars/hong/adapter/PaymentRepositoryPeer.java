package com.mars.hong.adapter;

import com.mars.hong.entity.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepositoryPeer extends CrudRepository<Payment, Long> {
}
