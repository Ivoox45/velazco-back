package com.velazco.velazco_back.controller;

import com.velazco.velazco_back.service.SaleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sales")
public class SaleController {
  @SuppressWarnings("unused")
  private final SaleService saleService;

  public SaleController(SaleService saleService) {
    this.saleService = saleService;
  }
}