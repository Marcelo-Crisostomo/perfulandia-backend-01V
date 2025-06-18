package com.perfulandia.boletaservice.service;
import com.perfulandia.boletaservice.model.*;
import com.perfulandia.boletaservice.repository.BoletaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class BoletaService {
    private final BoletaRepository repo;
    private final RestTemplate restTemplate;

    public BoletaService(BoletaRepository repo, RestTemplate restTemplate) {
        this.repo = repo;
        this.restTemplate = restTemplate;
    }

    public List<Boleta> listar() {
        return repo.findAll();
    }

    public Boleta emitirBoleta(Long idUsuario, Long idProducto) {
        // Llamada a usuarioservice
        Usuario usuario = restTemplate.getForObject("http://localhost:8081/api/usuarios/" + idUsuario, Usuario.class);

        // Llamada a productservice
        Producto producto = restTemplate.getForObject("http://localhost:8082/api/productos/" + idProducto, Producto.class);

        Boleta boleta = Boleta.builder()
                .nombreUsuario(usuario.getNombre())
                .correoUsuario(usuario.getCorreo())
                .nombreProducto(producto.getNombre())
                .precioProducto(producto.getPrecio())
                .fechaEmision(LocalDateTime.now())
                .build();

        return repo.save(boleta);
    }
}
