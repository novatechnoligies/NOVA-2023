package com.nova.dataservice.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.dataservice.entity.EmployeTracking;
import com.nova.dataservice.repository.EmployeTrackingRepository;
import com.nova.dataservice.service.EmployeTrackingService;

@Service
public class EmployeTrackingServiceImpl implements EmployeTrackingService{

	@Autowired
	EmployeTrackingRepository employeTrackingRepository;
	
	@Override
	public EmployeTracking saveEmployeTracking(EmployeTracking employeTracking) {
		// TODO Auto-generated method stub
		return employeTrackingRepository.save(employeTracking);
	}

	@Override
	public List<EmployeTracking> getEmployeDataByEmpIdAndDateRange(Long empId, LocalDate fromDate, LocalDate toDate) {
		// TODO Auto-generated method stub
		return null;
				//employeTrackingRepository.findByEmpIdAndCreatedAtBetween(empId, fromDate, toDate);
	}
}
