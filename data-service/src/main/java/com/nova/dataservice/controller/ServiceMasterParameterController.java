package com.nova.dataservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nova.dataservice.entity.ServiceMasterParameter;
import com.nova.dataservice.service.ServiceMasterParameterService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/v1")
public class ServiceMasterParameterController {
	@Autowired
	ServiceMasterParameterService masterParameterService;
	
	@PostMapping(value = "serviceMasterParameter")
	public ResponseEntity<Object> serviceMasterParameter(@RequestBody ServiceMasterParameter masterParameter) {
		try {
			ServiceMasterParameter data = masterParameterService.serviceMasterParameter(masterParameter);
			if (data != null) {
				return new ResponseEntity<Object>(data, HttpStatus.OK);

			} else {
				return new ResponseEntity<Object>("not Saved", HttpStatus.OK);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<Object>("something went wrong", HttpStatus.OK);
		}

	}
}
