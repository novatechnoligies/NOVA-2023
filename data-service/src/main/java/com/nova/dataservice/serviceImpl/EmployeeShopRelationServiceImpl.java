package com.nova.dataservice.serviceImpl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.dataservice.entity.EmployeeShopRelation;
import com.nova.dataservice.repository.EmployeeShopRelationRepository;
import com.nova.dataservice.service.EmployeeShopRelationService;

@Service
public class EmployeeShopRelationServiceImpl implements EmployeeShopRelationService{

	@Autowired
	EmployeeShopRelationRepository employeeShopRelationRepository;
	
	@Override
	public EmployeeShopRelation saveEmployeeShopRelation(EmployeeShopRelation employeeShopRelation) {
		employeeShopRelation.setStatus(true);
		employeeShopRelation.setIsDeleted(false);
		employeeShopRelation.setCreated_at(LocalDate.now());
		employeeShopRelation.setEmpCode("nova-"+employeeShopRelation.getShopId().getId()+"-"+employeeShopRelation.getEmpId().getId()+"-"+employeeShopRelation.getOwnerId());
		return employeeShopRelationRepository.save(employeeShopRelation);
	}
	
	

}
