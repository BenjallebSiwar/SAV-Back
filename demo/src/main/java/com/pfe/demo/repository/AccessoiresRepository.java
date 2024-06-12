package com.pfe.demo.repository;

import com.pfe.demo.entity.Accessoires;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessoiresRepository extends JpaRepository<Accessoires, Long> {
}
