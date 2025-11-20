package com.jg.backend.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ReservaProductoId implements Serializable {

    @Column(name = "reserva_id")
    private Long reservaId;

    @Column(name = "producto_id")
    private Long productoId;

}
