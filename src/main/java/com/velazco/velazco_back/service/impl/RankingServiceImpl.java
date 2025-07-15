package com.velazco.velazco_back.service.impl;

import com.velazco.velazco_back.dto.ranking.response.AreaRankingResponseDto;
import com.velazco.velazco_back.mappers.RankingMapper;
import com.velazco.velazco_back.repositories.SaleRepository;
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

  private final SaleRepository saleRepository;
  private final OrderRepository orderRepository;
  private final DispatchRepository dispatchRepository;
  private final ProductionRepository productionRepository;
  private final RankingMapper rankingMapper;

  @Override
  public AreaRankingResponseDto getAllRankings() {
    List<Object[]> rawVendedores = saleRepository.findTopVendedores();
    List<AreaRankingResponseDto.VendedorRankingDto> vendedores = rawVendedores.stream()
        .limit(5)
        .map(obj -> rankingMapper.toVendedorRankingDto(
            ((Number) obj[0]).longValue(),
            (String) obj[1],
            ((Number) obj[2]).intValue(),
            ((Number) obj[3]).doubleValue(),
            ((Number) obj[4]).doubleValue()))
        .toList();

    List<Object[]> rawCajeros = orderRepository.findTopCajeros();
    List<AreaRankingResponseDto.CajeroRankingDto> cajeros = rawCajeros.stream()
        .limit(5)
        .map(obj -> rankingMapper.toCajeroRankingDto(
            ((Number) obj[0]).longValue(),
            (String) obj[1],
            ((Number) obj[2]).intValue(),
            ((Number) obj[3]).doubleValue()))
        .toList();

    List<Object[]> rawEntregas = dispatchRepository.findTopEntregadores();
    List<AreaRankingResponseDto.EntregaRankingDto> entregas = rawEntregas.stream()
        .limit(5)
        .map(obj -> rankingMapper.toEntregaRankingDto(
            ((Number) obj[0]).longValue(),
            (String) obj[1],
            ((Number) obj[2]).intValue()))
        .toList();

    List<Object[]> rawProduccion = productionRepository.findTopProductores();
    List<AreaRankingResponseDto.ProduccionRankingDto> produccion = rawProduccion.stream()
        .limit(5)
        .map(obj -> rankingMapper.toProduccionRankingDto(
            ((Number) obj[0]).longValue(),
            (String) obj[1],
            ((Number) obj[2]).intValue(),
            ((Number) obj[3]).intValue(),
            ((Number) obj[4]).doubleValue()))
        .toList();
    return rankingMapper.toAreaRankingResponseDto(vendedores, cajeros, entregas, produccion);
  }
}
