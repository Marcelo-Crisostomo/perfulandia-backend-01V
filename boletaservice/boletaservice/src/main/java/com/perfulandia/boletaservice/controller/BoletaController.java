package com.perfulandia.boletaservice.controller;
import com.perfulandia.boletaservice.model.Boleta;
import com.perfulandia.boletaservice.service.BoletaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boletas")
public class BoletaController {
    private final BoletaService service;

    public BoletaController(BoletaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Boleta> listar() {
        return service.listar();
    }

    @PostMapping("/emitir")
    public Boleta emitir(@RequestParam Long usuarioId, @RequestParam Long productoId) {
        return service.emitirBoleta(usuarioId, productoId);
    }
}
