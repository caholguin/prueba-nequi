package com.prueba.nequi.service;

import com.prueba.nequi.dto.request.BranchRequest;
import com.prueba.nequi.dto.response.BranchResponse;
import com.prueba.nequi.entity.Branch;

public interface BranchService {

    BranchResponse create(BranchRequest branchRequest);

    BranchResponse update(Long id,BranchRequest branchRequest);

    Branch findById(Long id);
}
