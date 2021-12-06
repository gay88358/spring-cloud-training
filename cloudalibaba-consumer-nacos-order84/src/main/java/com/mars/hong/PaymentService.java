package com.mars.hong;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-payment-provider", fallback = PaymentServiceFallback.class)
@Component
public interface PaymentService {
    @GetMapping("/payments/{id}")
    ResponseEntity<ProductDTO> findPayments(@PathVariable("id") Long id);


    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    class ProductDTO {
        private Long id;
        private String name;
    }
}
