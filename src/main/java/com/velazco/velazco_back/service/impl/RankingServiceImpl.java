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
        // VENDEDORES
        List<Object[]> rawVendedores = saleRepository.findTopVendedores(); // [id, nombre, ventas, monto, promedio]
        List<AreaRankingResponseDto.VendedorRankingDto> vendedores = rawVendedores.stream()
                .limit(5)
                .map(obj -> rankingMapper.toVendedorRankingDto(
                        ((Number) obj[0]).longValue(),
                        (String) obj[1],
                        ((Number) obj[2]).intValue(),
                        ((Number) obj[3]).doubleValue(),
                        ((Number) obj[4]).doubleValue()))
                .toList();

        // CAJEROS
        List<Object[]> rawCajeros = orderRepository.findTopCajeros(); // [id, nombre, pedidos, ventas, total]
        List<AreaRankingResponseDto.CajeroRankingDto> cajeros = rawCajeros.stream()
                .limit(5)
                .map(obj -> rankingMapper.toCajeroRankingDto(
                        ((Number) obj[0]).longValue(),
                        (String) obj[1],
                        ((Number) obj[2]).intValue(),
                        ((Number) obj[3]).intValue(),
                        ((Number) obj[4]).doubleValue()))
                .toList();

        // ENTREGAS
        List<Object[]> rawEntregas = dispatchRepository.findTopEntregadores(); // [id, nombre, entregas, puntualidad,
                                                                               // distancia]
        List<AreaRankingResponseDto.EntregaRankingDto> entregas = rawEntregas.stream()
                .limit(5)
                .map(obj -> rankingMapper.toEntregaRankingDto(
                        ((Number) obj[0]).longValue(),
                        (String) obj[1],
                        ((Number) obj[2]).intValue(),
                        ((Number) obj[3]).doubleValue(),
                        ((Number) obj[4]).intValue()))
                .toList();

        // PRODUCCION
        List<Object[]> rawProduccion = productionRepository.findTopProductores(); // [id, nombre, ordenes, unidades,
                                                                                  // eficiencia]
        List<AreaRankingResponseDto.ProduccionRankingDto> produccion = rawProduccion.stream()
                .limit(5)
                .map(obj -> rankingMapper.toProduccionRankingDto(
                        ((Number) obj[0]).longValue(),
                        (String) obj[1],
                        ((Number) obj[2]).intValue(),
                        ((Number) obj[3]).intValue(),
                        ((Number) obj[4]).doubleValue()))
                .toList();

        // Construye y retorna el DTO global
        return rankingMapper.toAreaRankingResponseDto(vendedores, cajeros, entregas, produccion);
    }
}
