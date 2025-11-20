package com.jg.backend.service;

import com.jg.backend.domain.dto.CreateProductoRequest;
import com.jg.backend.domain.entity.Producto;

import java.util.List;

public interface ProductoService {

    List<Producto> getProductos();
    Producto getProducto(Long id);
    Producto createProducto(CreateProductoRequest createProductoRequest);
    Producto updateProducto(Long id, CreateProductoRequest createProductoRequest);
    void deleteProducto(Long id);
    
}
