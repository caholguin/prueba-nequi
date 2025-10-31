package com.prueba.nequi.mapper;

import com.prueba.nequi.dto.request.FranchiseRequest;
import com.prueba.nequi.dto.response.BranchResponse;
import com.prueba.nequi.dto.response.FranchiseResponse;
import com.prueba.nequi.entity.Franchise;

public class FranchiseMapper {

    public static FranchiseResponse toDto(Franchise franchise) {

        if (franchise == null) return null;

        FranchiseResponse franchiseResponse = new FranchiseResponse();
        franchiseResponse.setId(franchise.getId());
        franchiseResponse.setName(franchise.getName());

        return franchiseResponse;
    }

    public static Franchise toEntity(FranchiseRequest franchiseRequest) {

        if (franchiseRequest == null) return null;

        Franchise franchise = new Franchise();
        franchise.setName(franchiseRequest.getName());
        return franchise;
    }

    public static void updateEntity(Franchise franchise, FranchiseRequest franchiseRequest){
        if(franchise == null || franchiseRequest == null) return;

        franchise.setName(franchiseRequest.getName());
    }

    public static BranchResponse.FranchiseResponse toGetFranchiseDto(Franchise franchise){
        if (franchise == null ) return null;

        return new BranchResponse.FranchiseResponse(
                franchise.getId(),
                franchise.getName()
        );
    }
}
