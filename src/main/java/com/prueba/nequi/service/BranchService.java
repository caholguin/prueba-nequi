package com.prueba.nequi.service;

import com.prueba.nequi.dto.request.BranchRequest;
import com.prueba.nequi.dto.response.BranchResponse;

public interface BranchService {

    BranchResponse create(BranchRequest branchRequest);

    BranchResponse update(Long id,BranchRequest branchRequest);

    BranchResponse findById(Long id);
}
