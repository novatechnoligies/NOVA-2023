package com.nova.dataservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nova.dataservice.entity.EmployeTracking;
import com.nova.dataservice.entity.EmployeeShopRelation;
import com.nova.dataservice.service.EmployeeShopRelationService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/dataservice")
public class EmployeeShopRelationController {
	
	@Autowired
	EmployeeShopRelationService employeeShopRelationService;
	
	@PostMapping(value = "saveEmployeeShopRelation")
	public ResponseEntity<Object> saveEmployeeShopRelation(@RequestBody EmployeeShopRelation employeeShopRelation) {
		try {
			EmployeeShopRelation data = employeeShopRelationService.saveEmployeeShopRelation(employeeShopRelation);
			if (data!=null) {
				return new ResponseEntity<>(data, HttpStatus.OK);
			}else {
				return new ResponseEntity<>("fail to save data", HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("somthing went wrong fail to save data , due to MYSQL is down", HttpStatus.OK);
		}
	}

	
}
