package com.iudigital.rollerSpeed.controllers;

import com.iudigital.rollerSpeed.models.Aspirante;
import com.iudigital.rollerSpeed.models.Role;
import com.iudigital.rollerSpeed.models.User;
import com.iudigital.rollerSpeed.models.enums.RolesList;
import com.iudigital.rollerSpeed.repositories.AspiranteRepository;
import com.iudigital.rollerSpeed.repositories.RoleRepository;
import com.iudigital.rollerSpeed.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AspiranteController {

    @Autowired
    private AspiranteRepository aspiranteRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    // 1. Cargar el formulario de registro
    @GetMapping("/registro")
    public String mostrarFormulario(Model model) {
        model.addAttribute("aspirante", new Aspirante());
        return "registro"; 
    }

    // 2. Procesar y guardar el formulario enviado
    @PostMapping("/registro/guardar")
    public String guardarAspirante(@ModelAttribute("aspirante") Aspirante aspirante) {
        // Paso A: Guardar el aspirante en su respectiva tabla
        aspiranteRepository.save(aspirante);

        // Paso B: Buscar o asegurar que el rol TRAINEE exista
        Role traineeRole = roleRepository.findByName(RolesList.TRAINEE)
                .orElseGet(() -> {
                    Role newRole = new Role();
                    newRole.setName(RolesList.TRAINEE);
                    return roleRepository.save(newRole);
                });

        // Paso C: Crear el objeto User para que aparezca en la vista de trainees
        User nuevoUsuario = new User();
        nuevoUsuario.setName(aspirante.getNombre());

        // Como el formulario solo pide un campo "nombre", asignamos un apellido por defecto o temporal
        nuevoUsuario.setLastName("Registrado via Web");

        nuevoUsuario.setEmail(aspirante.getCorreo());
        nuevoUsuario.setPassword("123456"); // Contraseña temporal por defecto
        nuevoUsuario.setPhoneNumber(aspirante.getTelefono());
        nuevoUsuario.setRoles(List.of(traineeRole));

        // Guardar el usuario en la tabla "users" (Se activará el @PrePersist para fecha y estado active=true)
        userRepository.save(nuevoUsuario);

        return "redirect:/registro?exito";
    }
}
