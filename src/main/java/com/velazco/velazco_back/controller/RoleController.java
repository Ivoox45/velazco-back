package com.velazco.velazco_back.controller;

import com.velazco.velazco_back.service.RoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
  @SuppressWarnings("unused")
  private final RoleService roleService;

  public RoleController(RoleService roleService) {
    this.roleService = roleService;
  }
}