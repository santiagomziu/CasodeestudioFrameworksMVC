package com.iudigital.rollerSpeed.controllers.restControllers;

import com.iudigital.rollerSpeed.models.User;
import com.iudigital.rollerSpeed.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/trainees")
@Tag(name = "Módulo Estudiantes (Trainees)", description = "Operaciones CRUD para los alumnos en RollerSpeed")
public class UserApiController {

    private final UserService userService;

    public UserApiController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Obtener listado de estudiantes")
    @GetMapping
    public ResponseEntity<List<User>> getAllTrainees() {
        return ResponseEntity.ok(userService.listTrainees());
    }

    @Operation(summary = "Actualizar estudiante por ID", description = "Modifica los datos de un estudiante existente.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Estudiante actualizado correctamente"),
            @ApiResponse(responseCode = "404", description = "Estudiante no encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<User> updateTrainee(@PathVariable Long id, @RequestBody User userDetails) {
        return userService.findById(id)
                .map(user -> {
                    user.setName(userDetails.getName());
                    user.setLastName(userDetails.getLastName());
                    user.setEmail(userDetails.getEmail());
                    user.setPhoneNumber(userDetails.getPhoneNumber());
                    user.setActive(userDetails.isActive());
                    User updatedUser = userService.saveUser(user);
                    return ResponseEntity.ok(updatedUser);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Eliminar estudiante por ID", description = "Elimina permanentemente a un estudiante del sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Estudiante eliminado con éxito"),
            @ApiResponse(responseCode = "404", description = "Estudiante no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrainee(@PathVariable Long id) {
        if (userService.findById(id).isPresent()) {
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}