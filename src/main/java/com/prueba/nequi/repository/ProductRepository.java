package com.prueba.nequi.repository;

import com.prueba.nequi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query("SELECT p FROM Product p WHERE p.branch.id IN (SELECT b.id FROM Branch b WHERE b.franchise.id = :franchiseId) AND p.stock = ( SELECT MAX(p2.stock) FROM Product p2 WHERE p2.branch.id = p.branch.id)")
    List<Product> findTopProductsByFranchiseId(@Param("franchiseId") Long franchiseId);
}
