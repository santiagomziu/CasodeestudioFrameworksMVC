package com.iudigital.rollerSpeed.repositories;

import com.iudigital.rollerSpeed.models.User;
import com.iudigital.rollerSpeed.models.enums.RolesList;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {


}
