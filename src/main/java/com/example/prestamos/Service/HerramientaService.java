package com.example.prestamos.Service;

import com.example.prestamos.Entity.Herramienta;

import java.util.List;

public interface HerramientaService {
    Herramienta registrarHerramienta(Herramienta herramienta);
    List<Herramienta> obtenerHerramientas();
}
