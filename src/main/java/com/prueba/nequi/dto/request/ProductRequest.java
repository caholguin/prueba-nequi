package com.prueba.nequi.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public class ProductRequest implements Serializable {

    @NotBlank(message = "El campo nombre no puede estar vacío")
    private String name;

    @NotNull(message = "El campo stock es obligatorio")
    @Min(value = 0, message = "El stock no puede ser negativo")
    private Integer stock;

    @NotNull(message = "El campo sucursal es obligatorio")
    private Long branchId;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Integer getStock(){
        return stock;
    }

    public void setStock(Integer stock){
        this.stock = stock;
    }

    public Long getBranchId(){
        return branchId;
    }

    public void setBranchId(Long branchId){
        this.branchId = branchId;
    }
}
