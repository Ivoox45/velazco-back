package com.velazco.velazco_back.service.impl;

import com.velazco.velazco_back.repositories.RoleRepository;
import com.velazco.velazco_back.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
  @SuppressWarnings("unused")
  private final RoleRepository roleRepository;

  public RoleServiceImpl(RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }
}