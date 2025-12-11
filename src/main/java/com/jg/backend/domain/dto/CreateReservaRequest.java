package com.jg.backend.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateReservaRequest {

    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private List<Long> servicioIds;
    private List<CreateReservaProductRequest> products;

}
