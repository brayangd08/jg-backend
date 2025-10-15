package com.jg.backend.service;

import com.jg.backend.domain.dto.CreateReserva;
import com.jg.backend.domain.entity.Reserva;

import java.util.List;
import java.util.Optional;

public interface ReservaService {

    List<Reserva> getReservas();
    Reserva getReserva(Long id);
    Reserva createReserva(CreateReserva createReserva);
    Reserva updateReserva(CreateReserva createReserva);
    void deleteReserva(Long id);

}
