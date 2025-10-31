package com.prueba.nequi.service.impl;

import com.prueba.nequi.dto.request.BranchRequest;
import com.prueba.nequi.dto.response.BranchResponse;
import com.prueba.nequi.entity.Branch;
import com.prueba.nequi.entity.Franchise;
import com.prueba.nequi.exception.ObjectNotFoundException;
import com.prueba.nequi.mapper.BranchMapper;
import com.prueba.nequi.repository.BranchRepository;
import com.prueba.nequi.service.BranchService;
import com.prueba.nequi.service.FranchiseService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;
    private final FranchiseService franchiseService;

    public BranchServiceImpl(BranchRepository branchRepository, FranchiseService franchiseService){
        this.branchRepository = branchRepository;
        this.franchiseService = franchiseService;
    }

    @Override
    @Transactional
    public BranchResponse create(BranchRequest branchRequest){
        Franchise franchise = franchiseService.findById(branchRequest.getFranchiseId());
        Branch branch = BranchMapper.toEntity(branchRequest, franchise);
        return BranchMapper.toDto(branchRepository.save(branch));
    }

    @Override
    @Transactional
    public BranchResponse update(Long id, BranchRequest branchRequest){
        Franchise franchise = franchiseService.findById(branchRequest.getFranchiseId());
        Branch branch = this.findById(id);
        BranchMapper.updateEntity(branch,franchise,branchRequest);
        return BranchMapper.toDto(branchRepository.save(branch));
    }

    @Override
    public Branch findById(Long id){
        return branchRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Sucursal con id "+ id + " no encontrada"));
    }
}
