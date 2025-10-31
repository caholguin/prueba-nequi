package com.prueba.nequi.dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public class ProductResponse implements Serializable {

    private Long id;
    private String name;
    private int stock;
    private BranchResponse branch;

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getStock(){
        return stock;
    }

    public void setStock(int stock){
        this.stock = stock;
    }

    public BranchResponse getBranch(){
        return branch;
    }

    public void setBranch(BranchResponse branch){
        this.branch = branch;
    }

    public static class BranchResponse implements Serializable {
        private Long id;
        private String name;

        public BranchResponse(Long id, String name){
            this.id = id;
            this.name = name;
        }

        public Long getId(){
            return id;
        }

        public void setId(Long id){
            this.id = id;
        }

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }
    }
}
