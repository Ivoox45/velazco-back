package com.velazco.velazco_back.controller;

import com.velazco.velazco_back.dto.ranking.response.CajeroRankingDto;
import com.velazco.velazco_back.dto.ranking.response.EntregaRankingDto;
import com.velazco.velazco_back.dto.ranking.response.ProduccionRankingDto;
import com.velazco.velazco_back.dto.ranking.response.VendedorMesRankingDto;
import com.velazco.velazco_back.service.RankingService;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ranking")
@RequiredArgsConstructor
public class RankingController {

  private final RankingService rankingService;

  @GetMapping("/vendedores-mes")
  public List<VendedorMesRankingDto> getTopVendedoresDelMes() {
    return rankingService.getTopVendedoresDelMes();
  }

  @GetMapping("/cajeros-mes")
  public List<CajeroRankingDto> getCajerosDelMes() {
    return rankingService.getCajerosDelMes();
  }

  @GetMapping("/entregadores-mes")
  public List<EntregaRankingDto> getEntregadoresDelMes() {
    return rankingService.getEntregadoresDelMes();
  }

  @GetMapping("/produccion-mes")
  public List<ProduccionRankingDto> getProduccionDelMes() {
    return rankingService.getProduccionDelMes();
  }
}
