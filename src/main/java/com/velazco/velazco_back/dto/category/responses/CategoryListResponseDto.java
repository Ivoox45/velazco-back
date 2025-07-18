package com.velazco.velazco_back.dto.category.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryListResponseDto {
    private Long id;
    private String name;
}
