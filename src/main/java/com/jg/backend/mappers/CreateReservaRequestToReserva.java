package com.jg.backend.mappers;

import com.jg.backend.domain.dto.CreateReservaRequest;
import com.jg.backend.domain.entity.Reserva;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        imports = {UUID.class, ZoneOffset.class, LocalDateTime.class})
public interface CreateReservaRequestToReserva {

    @Mapping(source = "fecha", target = "fecha")
    @Mapping(source = "servicios", target = "servicios")
    Reserva mapCreateReservaRequestToReserva(
            CreateReservaRequest createReservaRequest);

}
