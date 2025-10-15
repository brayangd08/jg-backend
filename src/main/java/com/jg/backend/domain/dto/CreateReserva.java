package com.jg.backend.domain.dto;

import com.jg.backend.domain.entity.Servicio;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateReserva {

    private LocalDateTime fecha;
    private List<Servicio> servicios;

}
