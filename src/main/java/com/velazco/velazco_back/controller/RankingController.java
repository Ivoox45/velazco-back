package com.velazco.velazco_back.controller;

import com.velazco.velazco_back.dto.ranking.response.AreaRankingResponseDto;
import com.velazco.velazco_back.service.RankingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ranking")
@RequiredArgsConstructor
public class RankingController {

  private final RankingService rankingService;

  @PreAuthorize("hasAnyRole('Administrador','Cajero','Vendedor','Entregas', 'Producción')")
  @GetMapping("/areas")
  public ResponseEntity<AreaRankingResponseDto> getRankingAreas() {
    AreaRankingResponseDto ranking = rankingService.getAllRankings();
    return ResponseEntity.ok(ranking);
  }
}
