package com.prueba.nequi.dto.request;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public class ProductStockRequest implements Serializable {

    @NotNull(message = "El campo stock es obligatorio")
    private Integer stock;

    public Integer getStock(){
        return stock;
    }

    public void setStock(Integer stock){
        this.stock = stock;
    }
}
