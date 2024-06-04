package com.pfe.demo.repository;

import com.pfe.demo.entity.Intervention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterventionRepository extends JpaRepository<Intervention, Integer> {
   Intervention findByImei(Long imei);
   List<Intervention> findByClientCin(@Param("cin") Long cin);
}
