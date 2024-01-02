package com.nova.dataservice.service;

import java.util.List;
import java.util.Optional;

import com.nova.dataservice.entity.EmployeeDetails;

public interface EmployeDetailService {

	EmployeeDetails saveEmployeDetails(EmployeeDetails employeeDetails);

	List<EmployeeDetails> getAllEmployeDetails();

	Optional<EmployeeDetails> getEmployeByShopId(Long shopId);

}
