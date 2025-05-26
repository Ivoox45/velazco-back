package com.velazco.velazco_back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.velazco.velazco_back.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}