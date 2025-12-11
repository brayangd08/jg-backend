package com.jg.backend.service.impl;

import com.jg.backend.domain.dto.CreateBookingProductRequest;
import com.jg.backend.domain.dto.CreateBookingRequest;
import com.jg.backend.domain.entity.BookingProduct;
import com.jg.backend.domain.entity.Product;
import com.jg.backend.domain.entity.Booking;
import com.jg.backend.domain.entity.ServiceJg;
import com.jg.backend.exception.JgBadRequestException;
import com.jg.backend.exception.JgConflictException;
import com.jg.backend.exception.JgNotFoundException;
import com.jg.backend.repository.BookingRepository;
import com.jg.backend.repository.ServiceJgRepository;
import com.jg.backend.service.ProductService;
import com.jg.backend.service.BookingService;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {

    private BookingRepository bookingRepository;
    private ServiceJgRepository serviceJgRepository;
    private ProductService productService;

    @Override
    public List<Booking> getBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getBooking(Long id) {
        return bookingRepository.findById(id).orElseThrow(() -> new JgNotFoundException("Booking with id " + id + " not found"));
    }

    @Override
    public Booking createBooking(CreateBookingRequest createBookingRequest) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy'T'HH:mm:ss");
        LocalDateTime startDateTime = LocalDateTime.parse(createBookingRequest.getStartDate(), formatter);
        LocalDateTime endDateTime = LocalDateTime.parse(createBookingRequest.getEndDate(), formatter);

        validateDates(startDateTime, endDateTime);
        validateProductsAmount(createBookingRequest);

        Booking booking = createBookingRequestToBooking(createBookingRequest, startDateTime, endDateTime);

        booking = bookingRepository.save(booking);

        List<BookingProduct> bookingProducts = getBookingProduct(createBookingRequest.getProducts());

        return booking;
    }

    private void validateProductsAmount(CreateBookingRequest createBookingRequest) {
        createBookingRequest.getProducts().forEach(p -> {
            Product product = productService.getProduct(p.getId());
            if(product.getAmount() < p.getAmount()) {
                throw new JgBadRequestException("Product " + product.getName() + " has an availability of "
                        + product.getAmount() + " and is being requested an amount of " + p.getAmount());
            }
        });
    }

    private void validateDates(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        if(startDateTime.isEqual(endDateTime)) {
            throw new JgConflictException("End date: " + endDateTime +" is equal than start date: " + startDateTime);
        }
        if(endDateTime.isBefore(startDateTime)) {
            throw new JgConflictException("End date: " + endDateTime +" is before to start date: " + startDateTime);
        }
    }

    private Booking createBookingRequestToBooking(CreateBookingRequest createBookingRequest, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        List<ServiceJg> serviceJgs = getServiceJgs(createBookingRequest.getServiceJgIds());

        return Booking.builder()
                .startDate(startDateTime)
                .endDate(endDateTime)
                .serviceJgs(serviceJgs)
                .build();
    }

    private List<ServiceJg> getServiceJgs(List<Long> serviceJgIds) {
        return serviceJgIds.stream()
                .map(id -> serviceJgRepository.findById(id)
                        .orElseThrow(() -> new JgNotFoundException("Service with id " + id + " not found")))
                .toList();
    }

    //TODO how is gonna be implemented?
    private List<BookingProduct> getBookingProduct(List<CreateBookingProductRequest> createBookingProductRequest) {
        return createBookingProductRequest.stream().map(cbpr -> {
            productService.getProduct(cbpr.getId());
            return BookingProduct.builder().build();
        }).toList();
    }



    @Override
    public Booking updateBooking(Long id, CreateBookingRequest createBookingRequest) {
        Booking booking = getBooking(id);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy'T'HH:mm:ss");
        LocalDateTime startDateTime = LocalDateTime.parse(createBookingRequest.getStartDate(), formatter);
        LocalDateTime endDateTime = LocalDateTime.parse(createBookingRequest.getEndDate(), formatter);

        booking.setStartDate(startDateTime);
        booking.setEndDate(endDateTime);
        booking.setServiceJgs(getServiceJgs(createBookingRequest.getServiceJgIds()));

        return bookingRepository.save(booking);
    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}
