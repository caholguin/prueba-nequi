package com.prueba.nequi.controller;

import com.prueba.nequi.dto.request.ProductRequest;
import com.prueba.nequi.dto.response.ProductResponse;
import com.prueba.nequi.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> create(@RequestBody @Valid ProductRequest productRequest ){
        ProductResponse product = productService.create(productRequest);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> update(@PathVariable Long id, @RequestBody @Valid ProductRequest productRequest ){
        ProductResponse product = productService.update(id,productRequest);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/franchise/{franchiseId}")
    public ResponseEntity<List<ProductResponse>> findByFranchiseId(@PathVariable Long franchiseId){
        List<ProductResponse> products = productService.findByFranchiseId(franchiseId);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
