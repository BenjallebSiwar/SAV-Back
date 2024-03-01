package com.pfe.demo.repository;

import com.pfe.demo.entity.Available_client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvailableClientRepository extends CrudRepository<Available_client, Integer> {
}
