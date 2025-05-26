package com.velazco.velazco_back.service.impl;

import com.velazco.velazco_back.repositories.DispatchRepository;
import com.velazco.velazco_back.service.DispatchService;
import org.springframework.stereotype.Service;

@Service
public class DispatchServiceImpl implements DispatchService {
  @SuppressWarnings("unused")
  private final DispatchRepository dispatchRepository;

  public DispatchServiceImpl(DispatchRepository dispatchRepository) {
    this.dispatchRepository = dispatchRepository;
  }
}