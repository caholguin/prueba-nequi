package com.prueba.nequi.service.impl;

import com.prueba.nequi.dto.request.FranchiseRequest;
import com.prueba.nequi.dto.response.FranchiseResponse;
import com.prueba.nequi.entity.Franchise;
import com.prueba.nequi.exception.ObjectNotFoundException;
import com.prueba.nequi.mapper.FranchiseMapper;
import com.prueba.nequi.repository.FranchiseRepository;
import com.prueba.nequi.service.FranchiseService;
import org.springframework.stereotype.Service;

@Service
public class FranchiseServiceImpl implements FranchiseService {

    private final FranchiseRepository franchiseRepository;

    public FranchiseServiceImpl(FranchiseRepository franchiseRepository){
        this.franchiseRepository = franchiseRepository;
    }

    @Override
    public FranchiseResponse create(FranchiseRequest franchiseRequest){
        Franchise franchise = FranchiseMapper.toEntity(franchiseRequest);
        return FranchiseMapper.toDto(franchiseRepository.save(franchise));
    }

    @Override
    public FranchiseResponse update(Long id, FranchiseRequest franchiseRequest){
        Franchise franchise = this.findById(id);
        FranchiseMapper.updateEntity(franchise,franchiseRequest);
        return FranchiseMapper.toDto(franchiseRepository.save(franchise));
    }

    @Override
    public Franchise findById(Long id){
        return franchiseRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Franquicia con id "+ id + " no encontrada"));
    }
}
