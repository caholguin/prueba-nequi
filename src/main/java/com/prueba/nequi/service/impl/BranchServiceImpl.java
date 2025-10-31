package com.prueba.nequi.service.impl;

import com.prueba.nequi.dto.request.BranchRequest;
import com.prueba.nequi.dto.response.BranchResponse;
import com.prueba.nequi.dto.response.FranchiseResponse;
import com.prueba.nequi.entity.Branch;
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
        FranchiseResponse franchise = franchiseService.findById(branchRequest.getFranchiseId());
        Branch branch = BranchMapper.toEntity(branchRequest);
        return BranchMapper.toDto(branchRepository.save(branch),franchise);
    }

    @Override
    @Transactional
    public BranchResponse update(Long id, BranchRequest branchRequest){
        FranchiseResponse franchise = franchiseService.findById(branchRequest.getFranchiseId());
        Branch branch = this.findByIdEntity(id);
        BranchMapper.updateEntity(branch,branchRequest);
        return BranchMapper.toDto(branchRepository.save(branch),franchise);
    }

    @Override
    public BranchResponse findById(Long id){
        return BranchMapper.toDto(this.findByIdEntity(id));
    }

    private Branch findByIdEntity(Long id){
        return branchRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Sucursal con id "+ id + " no encontrada"));
    }
}
