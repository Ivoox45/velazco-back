package com.velazco.velazco_back.service;

import java.util.List;

import com.velazco.velazco_back.dto.user.request.UserCreateRequestDto;
import com.velazco.velazco_back.dto.user.request.UserUpdateRequestDto;
import com.velazco.velazco_back.dto.user.response.UserCreateResponseDto;
import com.velazco.velazco_back.dto.user.response.UserListResponseDto;
import com.velazco.velazco_back.dto.user.response.UserUpdateResponseDto;

public interface UserService {
    List<UserListResponseDto> getAllUsers();

    UserCreateResponseDto createUser(UserCreateRequestDto request);

    UserUpdateResponseDto updateUser(Long id, UserUpdateRequestDto request);

    void deleteUser(Long id);

}