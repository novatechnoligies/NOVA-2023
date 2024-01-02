package com.nova.dataservice.service;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nova.dataservice.entity.EmployeTracking;
import com.nova.dataservice.repository.EmployeTrackingRepository;

public interface EmployeTrackingService {
	
	
	EmployeTracking saveEmployeTracking(EmployeTracking employeTracking);

	List<EmployeTracking> getEmployeDataByEmpIdAndDateRange(Long empId, LocalDate fromDate, LocalDate toDate);

}
