package com.velazco.velazco_back.service;

import java.util.List;

import com.velazco.velazco_back.dto.production.request.ProductionCreateRequestDto;
import com.velazco.velazco_back.dto.production.request.ProductionFinalizeRequestDto;
import com.velazco.velazco_back.dto.production.request.ProductionStatusUpdateRequestDto;
import com.velazco.velazco_back.dto.production.request.ProductionUpdateRequestDto;
import com.velazco.velazco_back.dto.production.response.ProductionCreateResponseDto;
import com.velazco.velazco_back.dto.production.response.ProductionDailyResponseDto;
import com.velazco.velazco_back.dto.production.response.ProductionFinalizeResponseDto;
import com.velazco.velazco_back.dto.production.response.ProductionHistoryResponseDto;
import com.velazco.velazco_back.dto.production.response.ProductionPendingResponseDto;
import com.velazco.velazco_back.dto.production.response.ProductionStatusUpdateResponseDto;
import com.velazco.velazco_back.dto.production.response.ProductionUpdateResponseDto;
import com.velazco.velazco_back.model.User;

public interface ProductionService {
  public List<ProductionPendingResponseDto> getPendingProductions();

  ProductionCreateResponseDto createProduction(ProductionCreateRequestDto request, User assignedBy);

  void deleteProductionById(Long productionId);

  ProductionUpdateResponseDto updateProduction(Long productionId, ProductionUpdateRequestDto request,
      User updatedBy);

  List<ProductionDailyResponseDto> getDailyProductions();

  List<ProductionHistoryResponseDto> getCompletedAndIncompleteOrders();

  ProductionStatusUpdateResponseDto cambiarEstadoPendienteAEnProceso(Long id, ProductionStatusUpdateRequestDto dto);

  ProductionFinalizeResponseDto finalizarProduccion(Long productionId, ProductionFinalizeRequestDto request);

  public ProductionCreateResponseDto getProductionById(Long id);
}