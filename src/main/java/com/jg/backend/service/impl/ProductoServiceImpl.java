package com.jg.backend.service.impl;

import com.jg.backend.domain.dto.CreateProductoRequest;
import com.jg.backend.domain.entity.Producto;
import com.jg.backend.exception.JgNotFoundException;
import com.jg.backend.repository.ProductoRepository;
import com.jg.backend.service.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private ProductoRepository productoRepository;

    @Override
    public List<Producto> getProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto getProducto(Long id) {
        return productoRepository.findById(id).orElseThrow(() -> new JgNotFoundException("Producto con id " + id + " no encontrado"));
    }

    @Override
    public Producto createProducto(CreateProductoRequest createProductoRequest) {
        Producto producto = createProductoRequestToProducto(createProductoRequest);

        return productoRepository.save(producto);
    }

    private static Producto createProductoRequestToProducto(CreateProductoRequest createProductoRequest) {
        return Producto.builder()
                .nombre(createProductoRequest.getNombre())
                .cantidad(createProductoRequest.getCantidad())
                .descripcion(createProductoRequest.getDescripcion())
                .precio(createProductoRequest.getPrecio())
                .build();
    }

    @Override
    public Producto updateProducto(Long id, CreateProductoRequest createProductoRequest) {
        Producto producto = getProducto(id);

        producto.setNombre(createProductoRequest.getNombre());
        producto.setCantidad(createProductoRequest.getCantidad());
        producto.setDescripcion(createProductoRequest.getDescripcion());
        producto.setPrecio(createProductoRequest.getPrecio());

        return productoRepository.save(producto);
    }

    @Override
    public void deleteProducto(Long id) {

    }
}
