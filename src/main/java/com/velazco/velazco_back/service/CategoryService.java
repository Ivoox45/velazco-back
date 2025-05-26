package com.velazco.velazco_back.service;

import java.util.List;

import com.velazco.velazco_back.dto.category.requests.CategoryCreateRequestDto;
import com.velazco.velazco_back.dto.category.requests.CategoryUpdateRequestDto;
import com.velazco.velazco_back.dto.category.responses.CategoryCreateResponseDto;
import com.velazco.velazco_back.dto.category.responses.CategoryListResponseDto;
import com.velazco.velazco_back.dto.category.responses.CategoryUpdateResponseDto;
import com.velazco.velazco_back.model.Category;

public interface CategoryService {

    List<CategoryListResponseDto> getAllCategories();

    Category getCategoryById(Long id);

    CategoryCreateResponseDto createCategory(CategoryCreateRequestDto dto);

    CategoryUpdateResponseDto updateCategory(Long id, CategoryUpdateRequestDto dto);

    void deleteCategoryById(Long id);

}