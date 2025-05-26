package com.velazco.velazco_back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.velazco.velazco_back.model.Production;

public interface ProductionRepository extends JpaRepository<Production, Long> {
}