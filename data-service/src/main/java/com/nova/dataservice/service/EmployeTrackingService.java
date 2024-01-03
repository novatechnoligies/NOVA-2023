package com.nova.dataservice.service;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nova.dataservice.DTO.TrackingDTO;
import com.nova.dataservice.entity.EmployeTracking;
import com.nova.dataservice.repository.EmployeTrackingRepository;

public interface EmployeTrackingService {
	
	
	EmployeTracking saveEmployeTracking(EmployeTracking employeTracking);

	List<TrackingDTO> getEmployeeDetailsByShopIdAndOwnerId(Long shopId, Long ownerId);

	/*
	 * List<EmployeTracking> getEmployeDataByEmpIdAndDateRange(Long empId, LocalDate
	 * fromDate, LocalDate toDate);
	 */
}
