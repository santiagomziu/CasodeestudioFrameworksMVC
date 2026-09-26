package com.iudigital.rollerSpeed.repositories;

import com.iudigital.rollerSpeed.models.Role;
import com.iudigital.rollerSpeed.models.enums.RolesList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long > {
    Optional<Role> findByName(RolesList rolesList);
}
