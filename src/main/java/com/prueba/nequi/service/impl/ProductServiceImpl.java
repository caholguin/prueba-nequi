package com.prueba.nequi.service.impl;

import com.prueba.nequi.dto.request.ProductRequest;
import com.prueba.nequi.dto.request.ProductStockRequest;
import com.prueba.nequi.dto.response.ProductResponse;
import com.prueba.nequi.entity.Branch;
import com.prueba.nequi.entity.Product;
import com.prueba.nequi.exception.ObjectNotFoundException;
import com.prueba.nequi.exception.StockException;
import com.prueba.nequi.mapper.ProductMapper;
import com.prueba.nequi.repository.ProductRepository;
import com.prueba.nequi.service.BranchService;
import com.prueba.nequi.service.ProductService;
import jakarta.transaction.Transactional;
import org.apache.coyote.BadRequestException;
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

        validateStock(productRequest.getStock());

        Branch branch = branchService.findById(productRequest.getBranchId());
        Product product = ProductMapper.toEntity(productRequest,branch);
        return ProductMapper.toDto(productRepository.save(product));
    }

    @Override
    @Transactional
    public ProductResponse update(Long id, ProductRequest productRequest){

        validateStock(productRequest.getStock());

        Product product = this.findById(id);
        Branch branch = branchService.findById(productRequest.getBranchId());
        ProductMapper.updateEntity(product,productRequest,branch);
        return ProductMapper.toDto(productRepository.save(product));
    }

    @Override
    @Transactional
    public ProductResponse updateStock(Long id, ProductStockRequest productStockRequest) {

        validateStock(productStockRequest.getStock());

        Product product = this.findById(id);

        product.setStock(productStockRequest.getStock());

        return ProductMapper.toDto(productRepository.save(product));
    }

    @Override
    public void delete(Long id){
        Product product = this.findById(id);
        productRepository.delete(product);
    }

    @Override
    public List<ProductResponse> findByFranchiseId(Long franchiseId){
        List<Product> products = productRepository.findTopProductsByFranchiseId(franchiseId);

        if (products.isEmpty()) {
            throw new ObjectNotFoundException("No se encontraron productos para la franquicia con ID: " + franchiseId);
        }

        return ProductMapper.toDtoList(products);
    }

    private Product findById(Long id){
        return productRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Producto con ID: " + id + " no encontrada"));
    }

    private static void validateStock(int productRequest){
        if (productRequest < 0) {
            throw new StockException("El stock no puede ser negativo");
        }
    }
}
