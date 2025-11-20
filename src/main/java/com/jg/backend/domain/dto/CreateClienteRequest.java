package com.jg.backend.domain.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateClienteRequest {

    private String nombre;
    private String apellido;
    private String email;
    private int edad;
    private LocalDate fechaNacimiento;
    @Column(unique = true)
    private String cedula;

}
