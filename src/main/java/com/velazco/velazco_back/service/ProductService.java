package com.velazco.velazco_back.service;

import java.util.List;

import com.velazco.velazco_back.dto.product.requests.ProductCreateRequestDto;
import com.velazco.velazco_back.dto.product.requests.ProductUpdateRequestDto;
import com.velazco.velazco_back.dto.product.responses.ProductCreateResponseDto;
import com.velazco.velazco_back.dto.product.responses.ProductListResponseDto;
import com.velazco.velazco_back.dto.product.responses.ProductUpdateActiveResponseDto;
import com.velazco.velazco_back.dto.product.responses.ProductUpdateResponseDto;

public interface ProductService {

  List<ProductListResponseDto> getAllProducts();

  List<ProductListResponseDto> getAllAvailableProducts();

  ProductCreateResponseDto createProduct(ProductCreateRequestDto dto);

  ProductUpdateResponseDto updateProduct(Long id, ProductUpdateRequestDto dto);

  void deleteProductById(Long id);

  ProductUpdateActiveResponseDto updateProductActive(Long id, Boolean active);

}
