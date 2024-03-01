package com.pfe.demo.repository;

import com.pfe.demo.entity.Intervention_status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterventionStatusRepository extends JpaRepository<Intervention_status, Integer> {
}
