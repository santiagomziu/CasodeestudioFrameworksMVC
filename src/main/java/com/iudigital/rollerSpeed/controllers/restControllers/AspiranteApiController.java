package com.iudigital.rollerSpeed.controllers.restControllers;

import com.iudigital.rollerSpeed.models.Aspirante;
import com.iudigital.rollerSpeed.service.AspiranteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/aspirantes")
@Tag(name = "Módulo Aspirantes", description = "Operaciones para la gestión y registro de aspirantes en RollerSpeed")
public class AspiranteApiController {

    private final AspiranteService aspiranteService;

    public AspiranteApiController(AspiranteService aspiranteService) {
        this.aspiranteService = aspiranteService;
    }

    @Operation(summary = "Listar aspirantes", description = "Retorna una lista con todos los aspirantes inscritos.")
    @ApiResponse(responseCode = "200", description = "Lista obtenida correctamente")
    @GetMapping
    public ResponseEntity<List<Aspirante>> obtenerAspirantes() {
        return ResponseEntity.ok(aspiranteService.listarAspirantes());
    }

    @Operation(summary = "Registrar nuevo aspirante", description = "Guarda un nuevo aspirante a través de la API.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Aspirante creado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @PostMapping
    public ResponseEntity<Aspirante> crearAspirante(@RequestBody Aspirante aspirante) {
        Aspirante nuevoAspirante = aspiranteService.guardarAspirante(aspirante);
        return ResponseEntity.status(201).body(nuevoAspirante);
    }
}
