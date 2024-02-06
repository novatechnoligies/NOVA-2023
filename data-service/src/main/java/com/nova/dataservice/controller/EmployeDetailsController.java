package com.nova.dataservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nova.dataservice.entity.EmployeeDetails;
import com.nova.dataservice.service.EmployeDetailService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/dataService")
public class EmployeDetailsController {

	@Autowired
	EmployeDetailService employeDetailService;
	
	@PostMapping(value = "saveEmployeDetails")
	public ResponseEntity<Object>saveEmployeDetails(@RequestBody EmployeeDetails employeeDetails){
	try {
		EmployeeDetails data =	employeDetailService.saveEmployeDetails(employeeDetails);
		if (data!= null) {
			return new ResponseEntity<>(data,HttpStatus.OK);
		} else {
			return new ResponseEntity<>("fail to save data",HttpStatus.OK);
		}
	} catch (Exception e) {
		return new ResponseEntity<>("something went wrong while saving data",HttpStatus.OK);
	}
}
	
	@GetMapping(value = "/getAllEmployeDetails")
	public ResponseEntity<Object> getAllEmployeDetails() {
		try {
			List<EmployeeDetails> empList = employeDetailService.getAllEmployeDetails();
			if (empList!=null && !empList.isEmpty()) {
				return new ResponseEntity<Object>(empList,HttpStatus.OK);
			}else {
				return new ResponseEntity<Object>("fail to get data",HttpStatus.OK);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}  return new ResponseEntity<Object>("something went wrong fil to get data,due to MYSQL is down",HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/getEmployeByShopId/{shopId}")
	public ResponseEntity<Object> getEmployeByShopId(@PathVariable("shopId") Long shopId){
		try {
			Optional<EmployeeDetails> emp = employeDetailService.getEmployeByShopId(shopId);
			if (emp!=null && !emp.isPresent()) {
				return new ResponseEntity<Object>(emp,HttpStatus.OK);
			}else {
				return new ResponseEntity<Object>("fail to get data",HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>("something went worng fail to get data, due to MYSQL down",HttpStatus.OK);
		}
	}
}
