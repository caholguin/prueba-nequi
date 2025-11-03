package com.prueba.nequi.dto.request;

import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public class FranchiseRequest implements Serializable {

    @NotBlank(message = "El campo nombre no puede estar vacío")
    private String name;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
