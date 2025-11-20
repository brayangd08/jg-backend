package com.jg.backend.service;

import com.jg.backend.domain.dto.CreateReservaRequest;
import com.jg.backend.domain.entity.Reserva;

import java.util.List;

public interface ReservaService {

    List<Reserva> getReservas();
    Reserva getReserva(Long id);
    Reserva createReserva(CreateReservaRequest createReservaRequest);
    Reserva updateReserva(Long id, CreateReservaRequest createReservaRequest);
    void deleteReserva(Long id);

}
