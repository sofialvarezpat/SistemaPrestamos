package com.example.prestamos.Service.Serviceimpl;

import com.example.prestamos.Entity.Herramienta;
import com.example.prestamos.Entity.Prestamo;
import com.example.prestamos.Repository.HerramientaRepository;
import com.example.prestamos.Repository.PrestamoRepository;
import com.example.prestamos.Service.PrestamoService;
import com.example.prestamos.dto.PrestamoRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PrestamoServiceImpl implements PrestamoService {
    private final PrestamoRepository prestamoRepository;
    private final HerramientaRepository herramientaRepository;

    public PrestamoServiceImpl(PrestamoRepository prestamoRepository, HerramientaRepository herramientaRepository) {
        this.prestamoRepository = prestamoRepository;
        this.herramientaRepository = herramientaRepository;
    }
    @Override
    @Transactional
    public Prestamo registrarPrestamo(PrestamoRequest request) {
        // 1. Comprobar que la herramienta exista[cite: 10]
        Herramienta herramienta = herramientaRepository.findById(request.getHerramientaId())
                .orElseThrow(() -> new IllegalArgumentException("La herramienta solicitada no existe"));

        // 2. Rechazar si la cantidad es cero o negativa
        if (request.getCantidad() <= 0) {
            throw new IllegalArgumentException("La cantidad prestada debe ser mayor a cero");
        }

        // 3. Rechazar si la cantidad es superior a las unidades disponibles
        if (request.getCantidad() > herramienta.getCantidad()) {
            throw new IllegalArgumentException("No hay unidades suficientes. Disponibles: " + herramienta.getCantidad());
        }

        // 4. Descontar las unidades prestadas[cite: 10]
        herramienta.setCantidad(herramienta.getCantidad() - request.getCantidad());
        herramientaRepository.save(herramienta);

        // 5. Registrar el préstamo
        Prestamo prestamo = new Prestamo();
        prestamo.setResponsable(request.getResponsable());
        prestamo.setFechaPrestamo(request.getFechaPrestamo());
        prestamo.setCantidad(request.getCantidad());
        prestamo.setHerramienta(herramienta);

        return prestamoRepository.save(prestamo);
    }

    @Override
    public List<Prestamo> obtenerTodos() {
        return prestamoRepository.findAll();
    }

    @Override
    public List<Prestamo> obtenerPorHerramienta(Long herramientaId) {
        return prestamoRepository.findByHerramientaId(herramientaId);
    }
}
