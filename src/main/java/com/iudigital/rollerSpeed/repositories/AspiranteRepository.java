package com.iudigital.rollerSpeed.repositories;

import com.iudigital.rollerSpeed.models.Aspirante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AspiranteRepository extends JpaRepository<Aspirante, Long> {
    // JpaRepository provee automáticamente métodos como save(), findAll(), findById(), etc.
}
