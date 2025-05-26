package com.velazco.velazco_back.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.velazco.velazco_back.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

  @Query("SELECT p FROM Product p JOIN FETCH p.category c WHERE p.active = true AND p.stock > 0")
  List<Product> findAvailableProducts();
}