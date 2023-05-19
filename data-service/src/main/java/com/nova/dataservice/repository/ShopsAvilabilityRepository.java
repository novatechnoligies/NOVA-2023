package com.nova.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nova.dataservice.controller.ShopsAvailability;
@Repository
public interface ShopsAvilabilityRepository extends JpaRepository<ShopsAvailability, Long> {

}
