package com.example.prestamos.Controller;


import com.example.prestamos.Entity.Prestamo;
import com.example.prestamos.Service.PrestamoService;
import com.example.prestamos.dto.PrestamoRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {
    private final PrestamoService prestamoService;

    public PrestamoController(PrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }

    // POST /api/prestamos - Registrar préstamo
    @PostMapping
    public ResponseEntity<Prestamo> registrar(@Valid @RequestBody PrestamoRequest request) {
        return new ResponseEntity<>(prestamoService.registrarPrestamo(request), HttpStatus.CREATED);
    }

    // GET /api/prestamos - Consultar todos los préstamos
    @GetMapping
    public ResponseEntity<List<Prestamo>> consultarTodos() {
        return ResponseEntity.ok(prestamoService.obtenerTodos());
    }

    // GET /api/prestamos/herramienta/{id} - Consultar préstamos de una herramienta
    @GetMapping("/herramienta/{id}")
    public ResponseEntity<List<Prestamo>> consultarPorHerramienta(@PathVariable Long id) {
        return ResponseEntity.ok(prestamoService.obtenerPorHerramienta(id));
    }
}
