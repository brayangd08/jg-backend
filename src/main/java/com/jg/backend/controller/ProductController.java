package com.jg.backend.controller;

import com.jg.backend.domain.dto.CreateProductRequest;
import com.jg.backend.domain.entity.Product;
import com.jg.backend.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private ProductService ProductService;

    @GetMapping
    private List<Product> getProducts() {
        return ProductService.getProducts();
    }

    @GetMapping("/{id}")
    private Product getProduct(@PathVariable Long id) {
        return ProductService.getProduct(id);
    }

    @PostMapping
    private Product createProduct(@RequestBody CreateProductRequest createProductRequest) {
        return ProductService.createProduct(createProductRequest);
    }

    @PutMapping("/{id}")
    private Product updateProduct(@PathVariable Long id, @RequestBody CreateProductRequest createProductRequest) {
        return ProductService.updateProduct(id, createProductRequest);
    }

    @DeleteMapping("/{id}")
    private void deleteProduct(@PathVariable Long id) {
        ProductService.deleteProduct(id);
    }
    
}
