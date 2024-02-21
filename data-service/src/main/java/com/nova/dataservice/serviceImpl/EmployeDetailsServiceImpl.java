package com.nova.dataservice.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.dataservice.entity.EmployeeDetails;
import com.nova.dataservice.repository.EmployeDetailRepository;
import com.nova.dataservice.service.EmployeDetailService;

@Service
public class EmployeDetailsServiceImpl implements EmployeDetailService {

	@Autowired
	EmployeDetailRepository employeDetailRepository;
	
	@Override
	public EmployeeDetails saveEmployeDetails(EmployeeDetails employeeDetails) {
		return employeDetailRepository.save(employeeDetails);
	}

	@Override
	public List<EmployeeDetails> getAllEmployeDetails() {
		// TODO Auto-generated method stub
		return employeDetailRepository.findAll();
	}

	@Override
	public Optional<EmployeeDetails> getEmployeByShopId(Long shopId) {
		// TODO Auto-generated method stub
		return employeDetailRepository.findById(shopId);
	}
	
	

	
}
