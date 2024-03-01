package com.pfe.demo.repository;

import com.pfe.demo.entity.Swap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SwapRepository extends JpaRepository<Swap,Integer> {
}
