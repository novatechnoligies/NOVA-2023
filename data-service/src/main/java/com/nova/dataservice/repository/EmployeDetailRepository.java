package com.nova.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nova.dataservice.entity.EmployeeDetails;

@Repository
public interface EmployeDetailRepository extends JpaRepository<EmployeeDetails, Long>{

}
