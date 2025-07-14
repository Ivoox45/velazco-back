package com.velazco.velazco_back.controller;

import com.velazco.velazco_back.dto.roles.response.RoleDto;
import com.velazco.velazco_back.service.RoleService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RoleController {
  private final RoleService roleService;

  @GetMapping
  public List<RoleDto> getAllRoles() {
    return roleService.getAllRoles();
  }

}