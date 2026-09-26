package com.iudigital.rollerSpeed.service;


import com.iudigital.rollerSpeed.models.User;
import com.iudigital.rollerSpeed.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> listTrainees() {
        // Lógica actual para listar estudiantes
        return userRepository.findAll();
    }

    // Buscar por ID para la edición
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    // Guardar (funciona tanto para crear como para actualizar)
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con ID: " + id));

        // Limpia la relación en la tabla intermedia para evitar el conflicto de llave foránea
        user.getRoles().clear();
        userRepository.save(user);

        // Ahora elimina el usuario de forma segura
        userRepository.delete(user);
    }
}