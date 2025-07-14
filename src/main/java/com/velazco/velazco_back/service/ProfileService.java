package com.velazco.velazco_back.service;

import com.velazco.velazco_back.dto.profile.response.ProfileDto;
import com.velazco.velazco_back.model.User;

public interface ProfileService {

    ProfileDto getProfile(User user);
}
