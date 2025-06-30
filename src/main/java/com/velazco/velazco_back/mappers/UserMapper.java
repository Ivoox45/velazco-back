package com.velazco.velazco_back.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.velazco.velazco_back.dto.user.request.UserCreateRequestDto;
import com.velazco.velazco_back.dto.user.request.UserUpdateRequestDto;
import com.velazco.velazco_back.dto.user.response.UserCreateResponseDto;
import com.velazco.velazco_back.dto.user.response.UserUpdateResponseDto;
import com.velazco.velazco_back.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "sales", ignore = true)
  @Mapping(target = "attendedOrders", ignore = true)
  @Mapping(target = "dispatches", ignore = true)
  @Mapping(target = "assignedProductions", ignore = true)
  @Mapping(target = "responsibleProductions", ignore = true)
  @Mapping(target = "authorities", ignore = true)
  @Mapping(target = "role.id", source = "roleId")
  com.velazco.velazco_back.model.User toEntity(UserCreateRequestDto request);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "sales", ignore = true)
  @Mapping(target = "attendedOrders", ignore = true)
  @Mapping(target = "dispatches", ignore = true)
  @Mapping(target = "assignedProductions", ignore = true)
  @Mapping(target = "responsibleProductions", ignore = true)
  @Mapping(target = "authorities", ignore = true)
  @Mapping(target = "role.id", source = "roleId")
  User toEntity(UserUpdateRequestDto request);

  UserCreateResponseDto toUserCreateResponse(User user);

  UserUpdateResponseDto toUserUpdateResponse(User user);
}
