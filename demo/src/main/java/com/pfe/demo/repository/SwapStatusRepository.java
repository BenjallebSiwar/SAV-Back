package com.pfe.demo.repository;

import com.pfe.demo.entity.Swap_status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SwapStatusRepository extends JpaRepository<Swap_status, Integer> {
}
