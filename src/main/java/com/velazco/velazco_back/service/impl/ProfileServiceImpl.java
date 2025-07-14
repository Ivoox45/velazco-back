package com.velazco.velazco_back.service.impl;

import org.springframework.stereotype.Service;

import com.velazco.velazco_back.dto.profile.response.ProfileDto;
import com.velazco.velazco_back.model.User;
import com.velazco.velazco_back.mappers.UserMapper;
import com.velazco.velazco_back.service.ProfileService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final UserMapper userMapper;

    @Override
    public ProfileDto getProfile(User user) {
        return userMapper.toProfileDto(user);
    }
}
