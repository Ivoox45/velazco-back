package com.velazco.velazco_back.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.velazco.velazco_back.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByEmail(String email);
}