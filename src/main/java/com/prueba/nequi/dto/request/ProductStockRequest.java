package com.prueba.nequi.dto.request;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public class ProductStockRequest implements Serializable {

    @NotNull(message = "El stock es obligatorio")
    private int stock;

    public int getStock(){
        return stock;
    }

    public void setStock(int stock){
        this.stock = stock;
    }
}
