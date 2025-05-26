package com.velazco.velazco_back.service.impl;

import com.velazco.velazco_back.repositories.ProductionRepository;
import com.velazco.velazco_back.service.ProductionService;
import org.springframework.stereotype.Service;

@Service
public class ProductionServiceImpl implements ProductionService {
  @SuppressWarnings("unused")
  private final ProductionRepository productionRepository;

  public ProductionServiceImpl(ProductionRepository productionRepository) {
    this.productionRepository = productionRepository;
  }
}