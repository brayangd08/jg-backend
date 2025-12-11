package com.jg.backend.service.impl;

import com.jg.backend.domain.dto.CreateReservaRequest;
import com.jg.backend.domain.entity.Product;
import com.jg.backend.domain.entity.Reserva;
import com.jg.backend.domain.entity.Servicio;
import com.jg.backend.exception.JgBadRequestException;
import com.jg.backend.exception.JgConflictException;
import com.jg.backend.exception.JgNotFoundException;
import com.jg.backend.repository.ReservaRepository;
import com.jg.backend.repository.ServicioRepository;
import com.jg.backend.service.ProductService;
import com.jg.backend.service.ReservaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservaServiceImpl implements ReservaService {

    private ReservaRepository reservaRepository;
    private ServicioRepository servicioRepository;
    private ProductService productService;

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
        validateDates(createReservaRequest);
        validateCantidadProducts(createReservaRequest);

        Reserva reserva = createReservaRequestToReserva(createReservaRequest);

        return reservaRepository.save(reserva);
    }

    private void validateCantidadProducts(CreateReservaRequest createReservaRequest) {
        createReservaRequest.getProducts().forEach(p -> {
            Product product = productService.getProduct(p.getId());
            if(product.getAmount() < p.getCantidad()) {
                throw new JgBadRequestException("Product " + product.getName() + " has a availability of "
                        + product.getAmount() + " and is being requested an amount of " + p.getCantidad());
            }
        });
    }

    private void validateDates(CreateReservaRequest createReservaRequest) {
        if(createReservaRequest.getFechaFin().isEqual(createReservaRequest.getFechaInicio())) {
            throw new JgConflictException("Fecha final: " + createReservaRequest.getFechaFin() +" es igual que la fecha inicio: " + createReservaRequest.getFechaInicio());
        }
        if(createReservaRequest.getFechaFin().isBefore(createReservaRequest.getFechaInicio())) {
            throw new JgConflictException("Fecha final: " + createReservaRequest.getFechaFin() +" está antes que la fecha inicio: " + createReservaRequest.getFechaInicio());
        }
    }

    private Reserva createReservaRequestToReserva(CreateReservaRequest createReservaRequest) {
        List<Servicio> services = getServicios(createReservaRequest.getServicioIds());

        return Reserva.builder()
                .fechaInicio(createReservaRequest.getFechaInicio())
                .fechaFin(createReservaRequest.getFechaFin())
                .servicios(services).build();
    }

    private List<Servicio> getServicios(List<Long> servicioIds) {
        return servicioIds.stream()
                .map(id -> servicioRepository.findById(id)
                        .orElseThrow(() -> new JgNotFoundException("Service with id " + id + " not found")))
                .toList();
    }

    @Override
    public Reserva updateReserva(Long id, CreateReservaRequest createReservaRequest) {
        Reserva reserva = getReserva(id);

        reserva.setFechaInicio(createReservaRequest.getFechaInicio());
        reserva.setFechaFin(createReservaRequest.getFechaFin());
        reserva.setServicios(getServicios(createReservaRequest.getServicioIds()));

        return reservaRepository.save(reserva);
    }

    @Override
    public void deleteReserva(Long id) {
        reservaRepository.deleteById(id);
    }
}
