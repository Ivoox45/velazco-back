package com.velazco.velazco_back.service.impl;

import com.velazco.velazco_back.repositories.UserRepository;
import com.velazco.velazco_back.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
  @SuppressWarnings("unused")
  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }
}