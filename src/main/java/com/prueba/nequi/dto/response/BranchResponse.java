package com.prueba.nequi.dto.response;

import java.io.Serializable;

public class BranchResponse implements Serializable {

    private Long id;
    private String name;
    private FranchiseResponse franchise;

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

    public FranchiseResponse getFranchise(){
        return franchise;
    }

    public void setFranchise(FranchiseResponse franchise){
        this.franchise = franchise;
    }

    public static class FranchiseResponse implements Serializable {
        private Long id;
        private String name;

        public FranchiseResponse(Long id, String name){
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

    public static class ProductResponse implements Serializable {
        private Long id;
        private String name;

        public ProductResponse(Long id, String name){
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
