package com.velazco.velazco_back.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.velazco.velazco_back.dto.ranking.response.AreaRankingResponseDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RankingMapper {
    RankingMapper INSTANCE = Mappers.getMapper(RankingMapper.class);

    AreaRankingResponseDto.VendedorRankingDto toVendedorRankingDto(
            Long id, String nombre, Integer ventas, Double monto, Double promedio);

    AreaRankingResponseDto.CajeroRankingDto toCajeroRankingDto(
            Long id, String nombre, Integer ventas, Double total);

    AreaRankingResponseDto.EntregaRankingDto toEntregaRankingDto(
            Long id, String nombre, Integer entregas);

    AreaRankingResponseDto.ProduccionRankingDto toProduccionRankingDto(
            Long id, String nombre, Integer ordenes, Integer unidades, Double eficiencia);

    @Mapping(target = "vendedores", source = "vendedores")
    @Mapping(target = "cajeros", source = "cajeros")
    @Mapping(target = "entregas", source = "entregas")
    @Mapping(target = "produccion", source = "produccion")
    AreaRankingResponseDto toAreaRankingResponseDto(
            List<AreaRankingResponseDto.VendedorRankingDto> vendedores,
            List<AreaRankingResponseDto.CajeroRankingDto> cajeros,
            List<AreaRankingResponseDto.EntregaRankingDto> entregas,
            List<AreaRankingResponseDto.ProduccionRankingDto> produccion);
}
