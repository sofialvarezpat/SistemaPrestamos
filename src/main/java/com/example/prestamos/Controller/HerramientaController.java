package com.example.prestamos.Controller;


import com.example.prestamos.Entity.Herramienta;
import com.example.prestamos.Service.HerramientaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/herramientas")
public class HerramientaController {
    private final HerramientaService herramientaService;

    public HerramientaController(HerramientaService herramientaService) {
        this.herramientaService = herramientaService;
    }

    // POST /api/herramientas - Registrar herramienta
    @PostMapping
    public ResponseEntity<Herramienta> registrar(@Valid @RequestBody Herramienta herramienta) {
        return new ResponseEntity<>(herramientaService.registrarHerramienta(herramienta), HttpStatus.CREATED);
    }

    // GET /api/herramientas - Consultar herramientas
    @GetMapping
    public ResponseEntity<List<Herramienta>> consultarTodas() {
        return ResponseEntity.ok(herramientaService.obtenerHerramientas());
    }
}
