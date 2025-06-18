package com.perfulandia.boletaservice.model;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    private Long id;
    private String nombre;
    private double precio;
    private int stock;
}
