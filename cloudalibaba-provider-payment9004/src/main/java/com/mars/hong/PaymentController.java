package com.mars.hong;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payments/{id}")
    public ResponseEntity<ProductDTO> findPayments(@PathVariable("id") Long id) {
        if (id == 2) {
            throw new RuntimeException("");
        }
        return ResponseEntity.ok(new ProductDTO(id, serverPort));
    }

    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProductDTO {
        private Long id;
        private String name;
    }
}
