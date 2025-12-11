package com.jg.backend.mappers;

import com.jg.backend.domain.dto.CreateBookingRequest;
import com.jg.backend.domain.entity.Booking;
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
    @Mapping(source = "serviceJgs", target = "serviceJgs")
    Booking mapCreateReservaRequestToReserva(
            CreateBookingRequest createBookingRequest);

}
