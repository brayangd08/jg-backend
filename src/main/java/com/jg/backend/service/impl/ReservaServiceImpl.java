package com.jg.backend.service.impl;

import com.jg.backend.domain.dto.CreateReservaRequest;
import com.jg.backend.domain.entity.Reserva;
import com.jg.backend.domain.entity.Servicio;
import com.jg.backend.exception.JgNotFoundException;
import com.jg.backend.repository.ReservaRepository;
import com.jg.backend.repository.ServicioRepository;
import com.jg.backend.service.ReservaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservaServiceImpl implements ReservaService {

    private ReservaRepository reservaRepository;
    private ServicioRepository servicioRepository;

    @Override
    public List<Reserva> getReservas() {
        return reservaRepository.findAll();
    }

    @Override
    public Reserva getReserva(Long id) {
        return reservaRepository.findById(id).orElseThrow(() -> new JgNotFoundException("Reserva con id " + id + " no encontrada"));
    }

    @Override
    public Reserva createReserva(CreateReservaRequest createReservaRequest) {
        Reserva reserva = createReservaRequestToReserva(createReservaRequest);

        return reservaRepository.save(reserva);
    }

    private Reserva createReservaRequestToReserva(CreateReservaRequest createReservaRequest) {
        List<Servicio> services = createReservaRequest.getServicioIds().stream()
                .map(id -> servicioRepository.findById(id)
                        .orElseThrow(() -> new JgNotFoundException("Service with id " + id + " not found")))
                .toList();

        return Reserva.builder()
                .fecha(createReservaRequest.getFecha())
                .servicios(services).build();
    }

    @Override
    public Reserva updateReserva(CreateReservaRequest createReservaRequest) {
        return null;
    }

    @Override
    public void deleteReserva(Long id) {

    }
}
