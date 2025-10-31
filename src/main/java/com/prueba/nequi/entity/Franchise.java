package com.prueba.nequi.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "franchises")
public class Franchise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "franchise", cascade = CascadeType.ALL)
    private List<Branch> branches;

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

    public List<Branch> getBranches(){
        return branches;
    }

    public void setBranches(List<Branch> branches){
        this.branches = branches;
    }
}
