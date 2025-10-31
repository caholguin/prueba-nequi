package com.prueba.nequi.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "branches")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "franchise_id")
    private Franchise franchise;

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL)
    private List<Product> products;

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

    public Franchise getFranchise(){
        return franchise;
    }

    public void setFranchise(Franchise franchise){
        this.franchise = franchise;
    }

    public List<Product> getProducts(){
        return products;
    }

    public void setProducts(List<Product> products){
        this.products = products;
    }
}
