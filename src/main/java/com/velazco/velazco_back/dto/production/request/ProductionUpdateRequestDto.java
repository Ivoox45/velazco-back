package com.velazco.velazco_back.dto.production.request;

import java.time.LocalDate;
import java.util.List;

import com.velazco.velazco_back.model.Production.ProductionStatus;
import com.velazco.velazco_back.validation.UniqueField;

import jakarta.validation.Valid;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductionUpdateRequestDto {

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @Builder
  public static class ProductionDetailUpdateRequestDto {
    @NotNull
    @Positive
    Long productId;

    @NotNull
    @Positive
    @Min(1)
    Integer requestedQuantity;
  }

  @NotNull
  @FutureOrPresent
  LocalDate productionDate;

  @NotNull
  @Positive
  Long assignedToId;

  @NotNull
  ProductionStatus status;

  @Size(max = 1000)
  String comments;

  @NotNull
  @Size(min = 1)
  @UniqueField(fieldName = "productId")
  private List<@Valid ProductionDetailUpdateRequestDto> details;
}
