package com.nova.dataservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nova.dataservice.entity.AccessPermissions;
import com.nova.dataservice.entity.AppontmentDetails;
import com.nova.dataservice.service.AccessPermissionsService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/dataservice")
public class AccessPermissionsController {
	
	@Autowired
	AccessPermissionsService accessPermissionsServices;
	
	
	@PostMapping(value = "saveAccessPermissions")
	public ResponseEntity<Object> saveAccessPermissions(@RequestBody AccessPermissions accessPermissions) {
		try {
			AccessPermissions data = accessPermissionsServices.saveAccessPermissions(accessPermissions);
			if (data!=null) {
				return new ResponseEntity<>(data, HttpStatus.OK);
			}else {
				return new ResponseEntity<>("fail to save data", HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("somthing went wrong fail to save data , due to MYSQL is down", HttpStatus.OK);
		}
}
}
