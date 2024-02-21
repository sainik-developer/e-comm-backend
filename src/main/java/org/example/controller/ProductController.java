package org.example.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.example.dto.ProductDTO;
import org.example.mapper.ProductMapper;
import org.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Log
@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @GetMapping("/api/products")
    @CrossOrigin("*")
    public List<ProductDTO> products() {
        return productMapper.toDTO(productRepository.findAvailableProduct());
//        ProductDTO product = new ProductDTO();
//        product.setId(UUID.randomUUID());
//        product.setDesc("desc");
//        product.setName("prod1");
//        product.setPrice(10);
//        product.setImage("https://magecomp.com/blog/wp-content/uploads/2018/05/How-to-Get-Product-Image-URL-in-Magento-2-1024x512.png");
//        return Arrays.asList(product);
    }
}
