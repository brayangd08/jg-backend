package com.jg.backend.controller;

import com.jg.backend.domain.dto.CreateBookingRequest;
import com.jg.backend.domain.entity.Booking;
import com.jg.backend.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/booking")
public class BookingController {

    private BookingService BookingService;

    @GetMapping
    private List<Booking> getBookings() {
        return BookingService.getBookings();
    }

    @GetMapping("/{id}")
    private Booking getBooking(@PathVariable Long id) {
        return BookingService.getBooking(id);
    }

    @PostMapping
    private Booking createBooking(@RequestBody CreateBookingRequest createBookingRequest) {
        return BookingService.createBooking(createBookingRequest);
    }

    @PutMapping("/{id}")
    private Booking updateBooking(@PathVariable Long id, @RequestBody CreateBookingRequest createBookingRequest) {
        return BookingService.updateBooking(id, createBookingRequest);
    }

    @DeleteMapping("/{id}")
    private void deleteBooking(@PathVariable Long id) {
        BookingService.deleteBooking(id);
    }

}
