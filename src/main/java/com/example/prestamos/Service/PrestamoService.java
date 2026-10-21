package com.example.prestamos.Service;

import com.example.prestamos.Entity.Prestamo;
import com.example.prestamos.dto.PrestamoRequest;

import java.util.List;

public interface PrestamoService {
    Prestamo registrarPrestamo(PrestamoRequest request);
    List<Prestamo> obtenerTodos();
    List<Prestamo> obtenerPorHerramienta(Long herramientaId);
}
