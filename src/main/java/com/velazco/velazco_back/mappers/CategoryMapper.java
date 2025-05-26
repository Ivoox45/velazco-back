package com.velazco.velazco_back.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.velazco.velazco_back.dto.category.responses.CategoryListResponseDto;
import com.velazco.velazco_back.dto.category.responses.CategoryUpdateResponseDto;
import com.velazco.velazco_back.dto.category.requests.CategoryCreateRequestDto;
import com.velazco.velazco_back.dto.category.requests.CategoryUpdateRequestDto;
import com.velazco.velazco_back.dto.category.responses.CategoryCreateResponseDto;
import com.velazco.velazco_back.model.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    List<CategoryListResponseDto> toListResponse(List<Category> category);

    CategoryCreateResponseDto toCreateResponse(Category category);

    CategoryUpdateResponseDto toUpdateResponse(Category category);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "products", ignore = true)
    Category toEntity(CategoryCreateRequestDto dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "products", ignore = true)
    Category toEntity(CategoryUpdateRequestDto dto);
}
