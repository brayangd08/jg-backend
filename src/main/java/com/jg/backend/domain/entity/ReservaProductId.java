package com.jg.backend.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ReservaProductId implements Serializable {

    @Column(name = "reserva_id")
    private Long reservaId;

    @Column(name = "product_id")
    private Long productId;

}
