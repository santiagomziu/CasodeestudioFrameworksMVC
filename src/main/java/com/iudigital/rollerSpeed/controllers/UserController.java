package com.iudigital.rollerSpeed.controllers;

import com.iudigital.rollerSpeed.models.User;
import com.iudigital.rollerSpeed.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/trainees")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getAllTrainees(Model model) {
        model.addAttribute("trainees", userService.listTrainees());
        return "trainees";
    }

    // 1. Mostrar formulario de edición
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        User user = userService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de estudiante inválido:" + id));
        model.addAttribute("trainee", user);
        return "edit-trainee"; // Nombre de la nueva vista HTML
    }

    // 2. Procesar la actualización
    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute("trainee") User user) {
        User existingUser = userService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));

        // Actualizamos los campos permitidos
        existingUser.setName(user.getName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPhoneNumber(user.getPhoneNumber());
        existingUser.setActive(user.isActive());

        userService.saveUser(existingUser);
        return "redirect:/trainees?actualizado";
    }

    // 3. Eliminar estudiante
    @GetMapping("/delete/{id}")
    public String deleteTrainee(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/trainees?eliminado";
    }
}
