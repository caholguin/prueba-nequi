package com.prueba.nequi.service;

import com.prueba.nequi.dto.request.ProductRequest;
import com.prueba.nequi.dto.response.ProductResponse;

import java.util.List;

public interface ProductService {

    ProductResponse create(ProductRequest productRequest);

    ProductResponse update(Long id,ProductRequest productRequest);

    void delete(Long id);

    List<ProductResponse> findByFranchiseId(Long franchiseId);
}
