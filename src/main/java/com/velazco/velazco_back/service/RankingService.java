package com.velazco.velazco_back.service;

import java.util.List;

import com.velazco.velazco_back.dto.ranking.response.CajeroRankingDto;
import com.velazco.velazco_back.dto.ranking.response.EntregaRankingDto;
import com.velazco.velazco_back.dto.ranking.response.ProduccionRankingDto;
import com.velazco.velazco_back.dto.ranking.response.VendedorMesRankingDto;

public interface RankingService {
    List<VendedorMesRankingDto> getTopVendedoresDelMes();

    List<CajeroRankingDto> getCajerosDelMes();

    List<EntregaRankingDto> getEntregadoresDelMes();

    List<ProduccionRankingDto> getProduccionDelMes();
}