package com.iudigital.rollerSpeed.controllers;

import com.iudigital.rollerSpeed.models.Aspirante;
import com.iudigital.rollerSpeed.repositories.AspiranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AspiranteController {

    @Autowired
    private AspiranteRepository aspiranteRepository;

    // 1. Cargar el formulario de registro
    @GetMapping("/registro")
    public String mostrarFormulario(Model model) {
        model.addAttribute("aspirante", new Aspirante());
        return "registro"; // Buscará la plantilla registro.html
    }

    // 2. Procesar y guardar el formulario enviado
    @PostMapping("/registro/guardar")
    public String guardarAspirante(@ModelAttribute("aspirante") Aspirante aspirante) {
        aspiranteRepository.save(aspirante);
        return "redirect:/registro?exito";
    }
}
