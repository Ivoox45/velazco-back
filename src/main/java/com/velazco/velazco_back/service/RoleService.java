package com.velazco.velazco_back.service;

import java.util.List;

import com.velazco.velazco_back.dto.roles.response.RoleDto;

public interface RoleService {
    List<RoleDto> getAllRoles();
}