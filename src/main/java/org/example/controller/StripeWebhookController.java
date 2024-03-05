package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.example.entity.ProductDO;
import org.example.repository.ProductRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@Log
@RestController
@RequiredArgsConstructor
public class StripeWebhookController {

    private final ProductRepository productRepository;

    @PostMapping("/webhook")
    public void webhook(@RequestBody String payload) {
        log.info(payload);
        Optional<ProductDO> productDOOps = productRepository.findById(UUID.fromString(""));
        if (productDOOps.isPresent()) {
            ProductDO productDO = productDOOps.get();
            productDO.setQuantity(productDO.getQuantity() - 1);
            productRepository.save(productDO);
        }
    }
}
