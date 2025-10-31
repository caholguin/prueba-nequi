package com.prueba.nequi.mapper;

import com.prueba.nequi.dto.request.BranchRequest;
import com.prueba.nequi.dto.response.BranchResponse;
import com.prueba.nequi.dto.response.FranchiseResponse;
import com.prueba.nequi.dto.response.ProductResponse;
import com.prueba.nequi.entity.Branch;
import com.prueba.nequi.entity.Franchise;
import org.springframework.stereotype.Component;

@Component
public class BranchMapper {

    public static BranchResponse toDto(Branch branch, FranchiseResponse franchiseResponse) {

        if (branch == null || franchiseResponse == null) return null;

        BranchResponse branchResponse = new BranchResponse();
        branchResponse.setId(branch.getId());
        branchResponse.setName(branch.getName());
        branchResponse.setFranchise(new BranchResponse.FranchiseResponse(
                franchiseResponse.getId(),
                franchiseResponse.getName()
        ));

        return branchResponse;
    }

    public static BranchResponse toDto(Branch branch) {

        if (branch == null) return null;

        BranchResponse branchResponse = new BranchResponse();
        branchResponse.setId(branch.getId());
        branchResponse.setName(branch.getName());
        branchResponse.setFranchise(FranchiseMapper.toGetFranchiseDto(branch.getFranchise()));

        return branchResponse;
    }

    public static Branch toEntity(BranchRequest branchRequest) {

        if (branchRequest == null) return null;

        Branch branch = new Branch();
        branch.setName(branchRequest.getName());

        Franchise franchise = new Franchise();
        franchise.setId(branchRequest.getFranchiseId());

        branch.setFranchise(franchise);
        return branch;
    }

    public static void updateEntity(Branch branch, BranchRequest branchRequest){
        if(branch == null || branchRequest == null) return;

        branch.setName(branchRequest.getName());

        Franchise franchise = new Franchise();
        franchise.setId(branchRequest.getFranchiseId());
        branch.setFranchise(franchise);
    }

    public static ProductResponse.BranchResponse toBranchDTO(Branch branch){
        if (branch == null) return null;

        return new ProductResponse.BranchResponse(branch.getId(), branch.getName());
    }
}
