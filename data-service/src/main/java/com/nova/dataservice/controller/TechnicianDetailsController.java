package com.nova.dataservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nova.dataservice.entity.TechnicianDetails;
import com.nova.dataservice.service.TechnicianDetailsService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/dataservice")
public class TechnicianDetailsController {

	@Autowired
	TechnicianDetailsService techSer;
	
	@PostMapping(value = "saveTechnicianDetails")
	public ResponseEntity<Object> saveTechnicianDetails(@RequestBody TechnicianDetails technician) {
		try {
			TechnicianDetails data = techSer.saveTechnicianDetails(technician);
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
