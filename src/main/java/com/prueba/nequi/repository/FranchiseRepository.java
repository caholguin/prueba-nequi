package com.prueba.nequi.repository;

import com.prueba.nequi.entity.Franchise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FranchiseRepository extends JpaRepository<Franchise,Long> {
}
