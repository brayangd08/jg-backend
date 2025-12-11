package com.jg.backend.service;

import com.jg.backend.domain.dto.CreateBookingRequest;
import com.jg.backend.domain.entity.Booking;

import java.util.List;

public interface BookingService {

    List<Booking> getBookings();
    Booking getBooking(Long id);
    Booking createBooking(CreateBookingRequest createBookingRequest);
    Booking updateBooking(Long id, CreateBookingRequest createBookingRequest);
    void deleteBooking(Long id);

}
