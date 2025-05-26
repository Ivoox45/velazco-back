package com.velazco.velazco_back.service.impl;

import com.velazco.velazco_back.repositories.SaleRepository;
import com.velazco.velazco_back.service.SaleService;


import org.springframework.stereotype.Service;

@Service
public class SaleServiceImpl implements SaleService {
  @SuppressWarnings("unused")
  private final SaleRepository saleRepository;

  public SaleServiceImpl(SaleRepository saleRepository) {
    this.saleRepository = saleRepository;
  }

}