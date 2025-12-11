package com.jg.backend.service;

import com.jg.backend.domain.dto.CreateProductRequest;
import com.jg.backend.domain.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();
    Product getProduct(Long id);
    Product createProduct(CreateProductRequest createProductRequest);
    Product updateProduct(Long id, CreateProductRequest createProductRequest);
    void deleteProduct(Long id);
    
}
