package com.velazco.velazco_back.dto.production.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductionStatusUpdateResponseDto {
  private Long id;
  private String estadoAnterior;
  private String estadoActual;
}