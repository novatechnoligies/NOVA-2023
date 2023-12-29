package com.nova.dataservice.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nova.dataservice.DTO.AppoinmentDTO;
import com.nova.dataservice.entity.AppontmentDetails;


@Repository
public interface AppointmentDetailsRepository extends JpaRepository<AppontmentDetails, Long> {

}
