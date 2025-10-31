package com.prueba.nequi.service.impl;

import com.prueba.nequi.dto.request.ProductRequest;
import com.prueba.nequi.dto.response.BranchResponse;
import com.prueba.nequi.dto.response.FranchiseResponse;
import com.prueba.nequi.dto.response.ProductResponse;
import com.prueba.nequi.entity.Product;
import com.prueba.nequi.exception.ObjectNotFoundException;
import com.prueba.nequi.mapper.ProductMapper;
import com.prueba.nequi.repository.ProductRepository;
import com.prueba.nequi.service.BranchService;
import com.prueba.nequi.service.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final BranchService branchService;

    public ProductServiceImpl(ProductRepository productRepository, BranchService branchService){
        this.productRepository = productRepository;
        this.branchService = branchService;
    }

    @Override
    @Transactional
    public ProductResponse create(ProductRequest productRequest){
        BranchResponse branch = branchService.findById(productRequest.getBranchId());
        Product product = ProductMapper.toEntity(productRequest);
        return ProductMapper.toDto(productRepository.save(product), branch);
    }

    @Override
    @Transactional
    public ProductResponse update(Long id, ProductRequest productRequest){
        Product product = this.findByIdEntity(id);
        BranchResponse branch = branchService.findById(productRequest.getBranchId());
        ProductMapper.updateEntity(product,productRequest);
        return ProductMapper.toDto(productRepository.save(product),branch);
    }

    @Override
    public void delete(Long id){
        Product product = this.findByIdEntity(id);
        productRepository.delete(product);
    }

    @Override
    public List<ProductResponse> findByFranchiseId(Long franchiseId){
        List<Product> products = productRepository.findTopProductsByFranchiseId(franchiseId);
        return ProductMapper.toDtoList(products);
    }

    private Product findByIdEntity(Long id){
        return productRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Producto con ID: " + id + " no encontrada"));
    }
}
