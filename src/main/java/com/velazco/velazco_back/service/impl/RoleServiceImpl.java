package com.velazco.velazco_back.service.impl;

import com.velazco.velazco_back.dto.roles.response.RoleDto;
import com.velazco.velazco_back.mappers.RoleMapper;
import com.velazco.velazco_back.model.Role;
import com.velazco.velazco_back.repositories.RoleRepository;
import com.velazco.velazco_back.service.RoleService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
  private final RoleRepository roleRepository;

  private final RoleMapper roleMapper;

  @Override
  public List<RoleDto> getAllRoles() {
    List<Role> roles = roleRepository.findAll();
    return roleMapper.toListDto(roles);
  }

}