package com.velazco.velazco_back.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.velazco.velazco_back.dto.ranking.response.AreaRankingResponseDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RankingMapper {
    RankingMapper INSTANCE = Mappers.getMapper(RankingMapper.class);

    // Mapper para VendedorRankingDto
    AreaRankingResponseDto.VendedorRankingDto toVendedorRankingDto(
            Long id, String nombre, Integer ventas, Double monto, Double promedio);

    // Mapper para CajeroRankingDto
    AreaRankingResponseDto.CajeroRankingDto toCajeroRankingDto(
            Long id, String nombre, Integer pedidos, Integer ventas, Double total);

    // Mapper para EntregaRankingDto
    AreaRankingResponseDto.EntregaRankingDto toEntregaRankingDto(
            Long id, String nombre, Integer entregas, Double puntualidad, Integer distancia);

    // Mapper para ProduccionRankingDto
    AreaRankingResponseDto.ProduccionRankingDto toProduccionRankingDto(
            Long id, String nombre, Integer ordenes, Integer unidades, Double eficiencia);

    // Mapper para el DTO principal
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
