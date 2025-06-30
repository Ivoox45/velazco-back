package com.velazco.velazco_back.dto.production.request;

import lombok.Data;

@Data
public class ProductionStatusUpdateRequestDto {
    private String nuevoEstado; // Esperado: "EN_PROCESO"
}
