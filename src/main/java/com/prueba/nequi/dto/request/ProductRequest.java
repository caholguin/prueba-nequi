package com.prueba.nequi.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public class ProductRequest implements Serializable {

    @NotBlank(message = "El nombre no puede estar vacío")
    private String name;

    @NotNull(message = "El campo sucursal es obligatorio")
    private Long branchId;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Long getBranchId(){
        return branchId;
    }

    public void setBranchId(Long branchId){
        this.branchId = branchId;
    }
}
