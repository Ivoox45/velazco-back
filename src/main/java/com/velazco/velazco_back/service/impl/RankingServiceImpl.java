package com.velazco.velazco_back.service.impl;

import com.velazco.velazco_back.dto.ranking.response.CajeroRankingDto;
import com.velazco.velazco_back.dto.ranking.response.EntregaRankingDto;
import com.velazco.velazco_back.dto.ranking.response.ProduccionRankingDto;
import com.velazco.velazco_back.dto.ranking.response.VendedorMesRankingDto;
import com.velazco.velazco_back.mappers.RankingMapper;
import com.velazco.velazco_back.repositories.OrderRepository;
import com.velazco.velazco_back.repositories.DispatchRepository;
import com.velazco.velazco_back.repositories.ProductionRepository;
import com.velazco.velazco_back.service.RankingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RankingServiceImpl implements RankingService {

  private final OrderRepository orderRepository;
  private final DispatchRepository dispatchRepository;
  private final ProductionRepository productionRepository;

  @Override
  public List<VendedorMesRankingDto> getTopVendedoresDelMes() {
    return orderRepository.findTopVendedoresDelMes().stream()
        .limit(5)
        .map(obj -> VendedorMesRankingDto.builder()
            .id(((Number) obj[0]).longValue())
            .nombre((String) obj[1])
            .ventas(((Number) obj[2]).intValue())
            .monto(((Number) obj[3]).doubleValue())
            .build())
        .toList();
  }

  public List<CajeroRankingDto> getCajerosDelMes() {
    List<Object[]> results = orderRepository.findTopCajerosDelMes();
    return results.stream()
        .map(obj -> CajeroRankingDto.builder()
            .id(((Number) obj[0]).longValue())
            .nombre((String) obj[1])
            .ventas(((Number) obj[2]).intValue())
            .total(obj[3] != null ? ((Number) obj[3]).doubleValue() : 0.0)
            .build())
        .toList();
  }

  public List<EntregaRankingDto> getEntregadoresDelMes() {
    List<Object[]> results = dispatchRepository.findTopEntregadoresDelMes();
    return results.stream()
        .map(obj -> EntregaRankingDto.builder()
            .id(((Number) obj[0]).longValue())
            .nombre((String) obj[1])
            .entregas(((Number) obj[2]).intValue())
            .build())
        .toList();
  }

  public List<ProduccionRankingDto> getProduccionDelMes() {
    List<Object[]> results = productionRepository.findTopProductoresDelMes();
    return results.stream()
        .map(obj -> ProduccionRankingDto.builder()
            .id(((Number) obj[0]).longValue())
            .nombre((String) obj[1])
            .ordenes(((Number) obj[2]).intValue())
            .unidades(((Number) obj[3]).intValue())
            .eficiencia(obj[4] != null ? ((Number) obj[4]).doubleValue() : 0.0)
            .build())
        .toList();
  }
}
