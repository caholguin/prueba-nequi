package com.prueba.nequi.controller;

import com.prueba.nequi.dto.request.BranchRequest;
import com.prueba.nequi.dto.response.BranchResponse;
import com.prueba.nequi.service.BranchService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/branches")
public class BranchController {

    private final BranchService branchService;

    public BranchController(BranchService branchService){
        this.branchService = branchService;
    }

    @PostMapping
    public ResponseEntity<BranchResponse> create(@RequestBody @Valid BranchRequest branchRequest){
        BranchResponse branch = branchService.create(branchRequest);
        return new ResponseEntity<>(branch, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BranchResponse> update(@PathVariable Long id, @RequestBody @Valid BranchRequest branchRequest){
        BranchResponse branch = branchService.update(id,branchRequest);
        return new ResponseEntity<>(branch, HttpStatus.OK);
    }
}
