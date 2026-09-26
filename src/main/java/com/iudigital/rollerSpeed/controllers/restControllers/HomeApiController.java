package com.iudigital.rollerSpeed.controllers.restControllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/home")
@Tag(name = "Módulo Inicio / General", description = "Endpoints informativos y de estado de la API de RollerSpeed")
public class HomeApiController {

    @Operation(summary = "Estado de la API", description = "Retorna un mensaje JSON indicando que los servicios de RollerSpeed están activos.")
    @ApiResponse(responseCode = "200", description = "Servicio activo y respondiendo correctamente")
    @GetMapping("/index")
    public ResponseEntity<Map<String, String>> getHomeStatus() {
        Map<String, String> response = Map.of(
                "status", "success",
                "message", "Bienvenido a la API REST de RollerSpeed"
        );
        return ResponseEntity.ok(response);
    }
}
