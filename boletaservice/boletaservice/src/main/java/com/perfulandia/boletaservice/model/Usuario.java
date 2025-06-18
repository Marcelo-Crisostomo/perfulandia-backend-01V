package com.perfulandia.boletaservice.model;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    private Long id;
    private String nombre;
    private String correo;
    private String rol;
}
