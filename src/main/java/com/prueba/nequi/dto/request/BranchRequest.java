package com.prueba.nequi.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public class BranchRequest implements Serializable {

    @NotBlank(message = "El campo nombre no puede estar vacío")
    private String name;

    @NotNull(message = "La campo franquicia no debe estar vacía")
    private Long franchiseId;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Long getFranchiseId(){
        return franchiseId;
    }

    public void setFranchiseId(Long franchiseId){
        this.franchiseId = franchiseId;
    }
}
