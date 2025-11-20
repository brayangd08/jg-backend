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
@Entity(name = "reserva_producto")
public class ReservaProducto {

    @EmbeddedId
    private ReservaProductoId id;
    @ManyToOne
    @MapsId("reservaId") // Maps the bookId from the composite key
    @JoinColumn(name = "reserva_id")
    private Reserva reserva;
    @ManyToOne
    @MapsId("productoId") // Maps the publisherId from the composite key
    @JoinColumn(name = "producto_id")
    private Producto producto;
    private int cantidad;


}
