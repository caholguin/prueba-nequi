package com.prueba.nequi.controller;

import com.prueba.nequi.dto.request.FranchiseRequest;
import com.prueba.nequi.dto.response.FranchiseResponse;
import com.prueba.nequi.service.FranchiseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/franchises")
@Tag(name = "Franquicias")
public class FranchiseController {

    private final FranchiseService franchiseService;

    public FranchiseController(FranchiseService franchiseService){
        this.franchiseService = franchiseService;
    }

    @PostMapping
    @Operation( summary = "Crear franquicia")
    public ResponseEntity<FranchiseResponse> create(@RequestBody @Valid FranchiseRequest franchiseRequest){
        FranchiseResponse franchise = franchiseService.create(franchiseRequest);
        return new ResponseEntity<>(franchise, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation( summary = "Actualizar franquicia")
    public ResponseEntity<FranchiseResponse> update(@PathVariable Long id, @RequestBody @Valid FranchiseRequest franchiseRequest){
        FranchiseResponse franchise = franchiseService.update(id,franchiseRequest);
        return new ResponseEntity<>(franchise, HttpStatus.OK);
    }
}
