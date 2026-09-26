package com.iudigital.rollerSpeed.service;

import com.iudigital.rollerSpeed.models.Aspirante;
import com.iudigital.rollerSpeed.repositories.AspiranteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AspiranteService {
    private final AspiranteRepository aspiranteRepository;

    public AspiranteService(AspiranteRepository aspiranteRepository) {
        this.aspiranteRepository = aspiranteRepository;
    }

    public Aspirante guardarAspirante(Aspirante aspirante) {
        return aspiranteRepository.save(aspirante);
    }

    public List<Aspirante> listarAspirantes() {
        return aspiranteRepository.findAll();
    }
}
