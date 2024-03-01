package com.pfe.demo.repository;

import com.pfe.demo.entity.Discharge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DischargeRepository extends JpaRepository<Discharge,Integer> {
}
