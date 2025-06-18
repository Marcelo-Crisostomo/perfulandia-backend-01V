package com.perfulandia.boletaservice.model;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Boleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreUsuario;
    private String correoUsuario;

    private String nombreProducto;
    private double precioProducto;

    private LocalDateTime fechaEmision;
}
