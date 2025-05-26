package com.velazco.velazco_back.controller;

import com.velazco.velazco_back.service.DispatchService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dispatches")
public class DispatchController {
  @SuppressWarnings("unused")
  private final DispatchService dispatchService;

  public DispatchController(DispatchService dispatchService) {
    this.dispatchService = dispatchService;
  }
}