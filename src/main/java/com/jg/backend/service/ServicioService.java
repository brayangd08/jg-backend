package com.jg.backend.service;

import com.jg.backend.domain.dto.CreateServicioRequest;
import com.jg.backend.domain.entity.Servicio;

import java.util.List;

public interface ServicioService {

    List<Servicio> getServicios();
    Servicio getServicio(Long id);
    Servicio createServicio(CreateServicioRequest createServicioRequest);
    Servicio updateServicio(Long id, CreateServicioRequest createServicioRequest);
    void deleteServicio(Long id);
}
