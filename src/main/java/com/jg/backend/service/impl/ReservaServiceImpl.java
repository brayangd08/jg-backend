package com.jg.backend.service.impl;

import com.jg.backend.domain.dto.CreateReserva;
import com.jg.backend.domain.entity.Reserva;
import com.jg.backend.exception.JgNotFoundException;
import com.jg.backend.repository.ReservaRepository;
import com.jg.backend.service.ReservaService;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReservaServiceImpl implements ReservaService {

    private ReservaRepository reservaRepository;

    @Override
    public List<Reserva> getReservas() {
        return reservaRepository.findAll();
    }

    @Override
    public Reserva getReserva(Long id) {
        return reservaRepository.findById(id).orElseThrow(() -> new JgNotFoundException("Reserva con id " + id + " no encontrada"));
    }

    @Override
    public Reserva createReserva(CreateReserva createReserva) {
        return null;
    }

    @Override
    public Reserva updateReserva(CreateReserva createReserva) {
        return null;
    }

    @Override
    public void deleteReserva(Long id) {

    }
}
