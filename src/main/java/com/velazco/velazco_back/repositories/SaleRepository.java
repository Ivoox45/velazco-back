package com.velazco.velazco_back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.velazco.velazco_back.model.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

}