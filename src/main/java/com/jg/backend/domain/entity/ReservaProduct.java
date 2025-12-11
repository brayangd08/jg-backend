package com.jg.backend.domain.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity(name = "reserva_product")
public class ReservaProduct {

    @EmbeddedId
    private ReservaProductId id;
    @ManyToOne
    @MapsId("reservaId") // Maps the bookId from the composite key
    @JoinColumn(name = "reserva_id")
    private Reserva reserva;
    @ManyToOne
    @MapsId("productId") // Maps the publisherId from the composite key
    @JoinColumn(name = "product_id")
    private Product product;
    private int cantidad;


}
