package com.jg.backend.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class BookingProductId implements Serializable {

    @Column(name = "booking_id")
    private Long bookingId;

    @Column(name = "product_id")
    private Long productId;

}
