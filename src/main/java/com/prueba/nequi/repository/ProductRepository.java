package com.prueba.nequi.repository;

import com.prueba.nequi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query("""
                SELECT p FROM Product p
                INNER JOIN (
                    SELECT p2.branch.id as branchId, MAX(p2.stock) as maxStock
                    FROM Product p2
                    INNER JOIN p2.branch b
                    WHERE b.franchise.id = :franchiseId
                    GROUP BY p2.branch.id
                ) maxStocks ON p.branch.id = maxStocks.branchId AND p.stock = maxStocks.maxStock
                WHERE p.branch.franchise.id = :franchiseId
                ORDER BY p.branch.id
            """)
    List<Product> findTopProductsByFranchiseId(@Param("franchiseId") Long franchiseId);
}
