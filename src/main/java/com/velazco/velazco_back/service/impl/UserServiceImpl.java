package com.velazco.velazco_back.service.impl;

import com.velazco.velazco_back.dto.user.request.UserCreateRequestDto;
import com.velazco.velazco_back.dto.user.request.UserUpdateRequestDto;
import com.velazco.velazco_back.dto.user.response.UserCreateResponseDto;
import com.velazco.velazco_back.dto.user.response.UserListResponseDto;
import com.velazco.velazco_back.dto.user.response.UserUpdateResponseDto;
import com.velazco.velazco_back.exceptions.GeneralBadRequestException;
import com.velazco.velazco_back.mappers.UserMapper;
import com.velazco.velazco_back.model.Role;
import com.velazco.velazco_back.model.User;
import com.velazco.velazco_back.repositories.RoleRepository;
import com.velazco.velazco_back.repositories.UserRepository;
import com.velazco.velazco_back.service.UserService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;
  private final RoleRepository roleRepository;

  private final UserMapper userMapper;

  private final PasswordEncoder passwordEncoder;

  @Override
  public List<UserListResponseDto> getAllUsers() {
    List<User> users = userRepository.findAll();
    return userMapper.toUserListResponseDtoList(users);
  }

  @Override
  public UserCreateResponseDto createUser(UserCreateRequestDto request) {
    User user = userMapper.toEntity(request);

    Role role = roleRepository.findById(request.getRoleId())
        .orElseThrow(() -> new EntityNotFoundException("Role not found"));

    user.setRole(role);
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    userRepository.save(user);

    UserCreateResponseDto response = userMapper.toUserCreateResponse(user);
    return response;
  }

  @Override
  public UserUpdateResponseDto updateUser(Long id, UserUpdateRequestDto request) {
    User existing = userRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("User not found"));

    existing.setName(request.getName());
    existing.setEmail(request.getEmail());
    existing.setActive(request.getActive());

    Role role = roleRepository.findById(request.getRoleId())
        .orElseThrow(() -> new EntityNotFoundException("Role not found"));
    existing.setRole(role);

    if (request.getPassword() != null && !request.getPassword().isBlank()) {
      existing.setPassword(passwordEncoder.encode(request.getPassword()));
    }

    UserUpdateResponseDto response = userMapper.toUserUpdateResponse(userRepository.save(existing));

    return response;
  }

  @Override
  public void deleteUser(Long id) {
    User user = userRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("User not found"));

    try {
      userMapper.toUserCreateResponse(user);
      userRepository.delete(user);
    } catch (Exception e) {
      throw new GeneralBadRequestException("No se puede eliminar el usuario porque está asociado a otros registros");
    }
  }
}