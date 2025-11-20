package com.jg.backend.controller;

import com.jg.backend.domain.dto.CreateProductoRequest;
import com.jg.backend.domain.entity.Producto;
import com.jg.backend.service.ProductoService;
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
@RequestMapping("/producto")
public class ProductoController {

    private ProductoService productoService;

    @GetMapping
    private List<Producto> getProductos() {
        return productoService.getProductos();
    }

    @GetMapping("/{id}")
    private Producto getProducto(@PathVariable Long id) {
        return productoService.getProducto(id);
    }

    @PostMapping
    private Producto createProducto(@RequestBody CreateProductoRequest createProductoRequest) {
        return productoService.createProducto(createProductoRequest);
    }

    @PutMapping("/{id}")
    private Producto updateProducto(@PathVariable Long id, @RequestBody CreateProductoRequest createProductoRequest) {
        return productoService.updateProducto(id, createProductoRequest);
    }

    @DeleteMapping("/{id}")
    private void deleteProducto(@PathVariable Long id) {
        productoService.deleteProducto(id);
    }
    
}
