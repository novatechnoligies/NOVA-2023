package com.nova.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SlotAvailabilityRepository extends JpaRepository<SlotAvailability, Long> {

}
