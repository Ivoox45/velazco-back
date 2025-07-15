package com.velazco.velazco_back.dto.ranking.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EntregaRankingDto {
    private Long id;
    private String nombre;
    private Integer entregas;
}
