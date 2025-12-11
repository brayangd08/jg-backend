package com.jg.backend.service.impl;

import com.jg.backend.domain.dto.CreateProductRequest;
import com.jg.backend.domain.entity.Product;
import com.jg.backend.exception.JgNotFoundException;
import com.jg.backend.repository.ProductRepository;
import com.jg.backend.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository ProductRepository;

    @Override
    public List<Product> getProducts() {
        return ProductRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return ProductRepository.findById(id).orElseThrow(() -> new JgNotFoundException("Product with id " + id + " not found"));
    }

    @Override
    public Product createProduct(CreateProductRequest createProductRequest) {
        Product Product = createProductRequestToProduct(createProductRequest);

        return ProductRepository.save(Product);
    }

    private static Product createProductRequestToProduct(CreateProductRequest createProductRequest) {
        return Product.builder()
                .name(createProductRequest.getName())
                .amount(createProductRequest.getAmount())
                .description(createProductRequest.getDescription())
                .price(createProductRequest.getPrice())
                .build();
    }

    @Override
    public Product updateProduct(Long id, CreateProductRequest createProductRequest) {
        Product Product = getProduct(id);

        Product.setName(createProductRequest.getName());
        Product.setAmount(createProductRequest.getAmount());
        Product.setDescription(createProductRequest.getDescription());
        Product.setPrice(createProductRequest.getPrice());

        return ProductRepository.save(Product);
    }

    @Override
    public void deleteProduct(Long id) {

    }
}
