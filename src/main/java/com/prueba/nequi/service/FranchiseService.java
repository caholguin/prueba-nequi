package com.prueba.nequi.service;

import com.prueba.nequi.dto.request.FranchiseRequest;
import com.prueba.nequi.dto.response.FranchiseResponse;
import com.prueba.nequi.entity.Franchise;

public interface FranchiseService {

    FranchiseResponse create(FranchiseRequest franchiseRequest);

    FranchiseResponse update(Long id, FranchiseRequest franchiseRequest);

    Franchise findById(Long id);
}
