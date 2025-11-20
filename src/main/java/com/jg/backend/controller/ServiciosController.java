package com.jg.backend.controller;

import com.jg.backend.domain.dto.CreateServicioRequest;
import com.jg.backend.domain.entity.Servicio;
import com.jg.backend.service.ServicioService;
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
@RequestMapping("/servicio")
public class ServiciosController {

    private ServicioService servicioService;

    @GetMapping
    private List<Servicio> getServicios() {
        return servicioService.getServicios();
    }

    @GetMapping("/{id}")
    private Servicio getServicio(@PathVariable Long id) {
        return servicioService.getServicio(id);
    }

    @PostMapping
    private Servicio createServicio(@RequestBody CreateServicioRequest createServicioRequest) {
        return servicioService.createServicio(createServicioRequest);
    }

    @PutMapping("/{id}")
    private Servicio updateServicio(@PathVariable Long id, @RequestBody CreateServicioRequest createServicioRequest) {
        return servicioService.updateServicio(id, createServicioRequest);
    }

    @DeleteMapping("/{id}")
    private void deleteServicio(@PathVariable Long id) {
        servicioService.deleteServicio(id);
    }
    
}
