package com.nova.dataservice.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nova.dataservice.entity.EmployeTracking;

@Repository
public interface EmployeTrackingRepository extends JpaRepository<EmployeTracking, Long>{

	//List<EmployeTracking> findByEmpIdAndCreatedAtBetween(Long empId, LocalDate fromDate, LocalDate toDate);

}
