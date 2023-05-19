package com.nova.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nova.dataservice.entity.SlotAvailability;
@Repository
public interface SlotAvailabilityRepository extends JpaRepository<SlotAvailability, Long> {

}
