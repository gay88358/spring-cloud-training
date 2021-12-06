package com.mars.hong;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class PaymentServiceFallback implements PaymentService {
    @Override
    public ResponseEntity<ProductDTO> findPayments(Long id) {
        return ResponseEntity.ok(new ProductDTO(1L, "fallback"));
    }
}
