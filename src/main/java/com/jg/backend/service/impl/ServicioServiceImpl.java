package com.jg.backend.service.impl;

import com.jg.backend.domain.dto.CreateServicioRequest;
import com.jg.backend.domain.entity.Servicio;
import com.jg.backend.exception.JgNotFoundException;
import com.jg.backend.repository.ServicioRepository;
import com.jg.backend.service.ServicioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServicioServiceImpl implements ServicioService {

    private ServicioRepository servicioRepository;

    @Override
    public List<Servicio> getServicios() {
        return servicioRepository.findAll();
    }

    @Override
    public Servicio getServicio(Long id) {
        return servicioRepository.findById(id).orElseThrow(() -> new JgNotFoundException("Servicio con id " + id + " no encontrado"));
    }

    @Override
    public Servicio createServicio(CreateServicioRequest createServicioRequest) {
        Servicio servicio = createServicioRequestToServicio(createServicioRequest);

        return servicioRepository.save(servicio);
    }

    private Servicio createServicioRequestToServicio(CreateServicioRequest createServicioRequest) {
        return Servicio.builder().nombre(createServicioRequest.getNombre()).precio(createServicioRequest.getPrecio()).descripcion(createServicioRequest.getDescripcion()).build();
    }

    @Override
    public Servicio updateServicio(Long id, CreateServicioRequest createServicioRequest) {
        Servicio servicio = getServicio(id);

        servicio.setNombre(createServicioRequest.getNombre());
        servicio.setDescripcion(createServicioRequest.getDescripcion());
        servicio.setPrecio(createServicioRequest.getPrecio());

        return servicioRepository.save(servicio);
    }

    @Override
    public void deleteServicio(Long id) {
        servicioRepository.deleteById(id);
    }

}
