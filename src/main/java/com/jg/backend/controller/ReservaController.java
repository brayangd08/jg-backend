package com.jg.backend.controller;

import com.jg.backend.domain.dto.CreateReserva;
import com.jg.backend.domain.entity.Reserva;
import com.jg.backend.service.ReservaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ReservaController {

    private ReservaService reservaService;

    @GetMapping
    private List<Reserva> getReservas() {
        return reservaService.getReservas();
    }

    @GetMapping("/{id}")
    private Reserva getReserva(@PathVariable Long id) {
        return reservaService.getReserva(id);
    }

    @PostMapping
    private Reserva createReserva(@RequestBody CreateReserva createReserva) {
        return reservaService.createReserva(createReserva);
    }

    @PutMapping
    private Reserva updateReserva(@RequestBody CreateReserva createReserva) {
        return reservaService.updateReserva(createReserva);
    }

    @DeleteMapping("/{id}")
    private void deleteReserva(@PathVariable Long id) {
        reservaService.deleteReserva(id);
    }

}
