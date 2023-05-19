package com.nova.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nova.dataservice.entity.AppontmentDetails;


@Repository
public interface AppointmentDetailsRepository extends JpaRepository<AppontmentDetails, Long> {


}
