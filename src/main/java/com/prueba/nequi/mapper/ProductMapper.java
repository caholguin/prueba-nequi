package com.prueba.nequi.mapper;

import com.prueba.nequi.dto.request.ProductRequest;
import com.prueba.nequi.dto.response.ProductResponse;
import com.prueba.nequi.entity.Branch;
import com.prueba.nequi.entity.Product;

import java.util.List;

public class ProductMapper {

    public static ProductResponse toDto(Product product) {

        if (product == null) return null;

        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setName(product.getName());
        productResponse.setStock(product.getStock());
        productResponse.setBranch(BranchMapper.toBranchDTO(product.getBranch()));

        return productResponse;
    }

    public static List<ProductResponse> toDtoList(List<Product> products){

        if (products == null) return null;

        return products.stream()
                .map(ProductMapper::toDto)
                .toList();
    }

    public static Product toEntity(ProductRequest productRequest, Branch branch) {

        if (productRequest == null) return null;

        Product product = new Product();
        product.setName(productRequest.getName());
        product.setStock(productRequest.getStock());
        product.setBranch(branch);
        return product;
    }

    public static void updateEntity(Product product, ProductRequest productRequest, Branch branch){

        if(product == null || productRequest == null) return;

        product.setName(productRequest.getName());
        product.setStock(productRequest.getStock());
        product.setBranch(branch);
    }
}
