package com.example.prestamos.Service.Serviceimpl;

import com.example.prestamos.Entity.Herramienta;
import com.example.prestamos.Repository.HerramientaRepository;
import com.example.prestamos.Service.HerramientaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HerramientaServiceImpl implements HerramientaService {
    private final HerramientaRepository herramientaRepository;

    public HerramientaServiceImpl(HerramientaRepository herramientaRepository) {
        this.herramientaRepository = herramientaRepository;
    }

    @Override
    public Herramienta registrarHerramienta(Herramienta herramienta) {
        return herramientaRepository.save(herramienta);
    }

    @Override
    public List<Herramienta> obtenerHerramientas() {
        return herramientaRepository.findAll();
    }
}
