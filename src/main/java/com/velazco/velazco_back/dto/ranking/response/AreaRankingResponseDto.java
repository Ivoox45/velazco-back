package com.velazco.velazco_back.dto.ranking.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AreaRankingResponseDto {

    private List<VendedorRankingDto> vendedores;
    private List<CajeroRankingDto> cajeros;
    private List<EntregaRankingDto> entregas;
    private List<ProduccionRankingDto> produccion;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class VendedorRankingDto {
        private Long id;
        private String nombre;
        private Integer ventas;
        private Double monto;
        private Double promedio;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class CajeroRankingDto {
        private Long id;
        private String nombre;
        private Integer ventas;
        private Double total;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class EntregaRankingDto {
        private Long id;
        private String nombre;
        private Integer entregas;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class ProduccionRankingDto {
        private Long id;
        private String nombre;
        private Integer ordenes;
        private Integer unidades;
        private Double eficiencia;
    }
}
