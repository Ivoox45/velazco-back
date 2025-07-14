package com.velazco.velazco_back.service;

import com.velazco.velazco_back.model.RefreshToken;
import com.velazco.velazco_back.model.User;

public interface RefreshTokenService {

  RefreshToken createRefreshToken(User user, String deviceInfo);

  RefreshToken verifyExpiration(RefreshToken token);

  RefreshToken findByToken(String token);

  void revokeRefreshToken(String token);

  void revokeAllUserTokens(User user);

  void deleteExpiredTokens();
}
