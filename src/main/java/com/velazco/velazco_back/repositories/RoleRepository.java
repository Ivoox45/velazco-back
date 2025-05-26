package com.velazco.velazco_back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.velazco.velazco_back.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}