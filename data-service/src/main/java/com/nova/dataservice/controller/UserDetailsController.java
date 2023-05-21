package com.nova.dataservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nova.dataservice.entity.UserDetails;
import com.nova.dataservice.service.UserDetailsServices;

@RestController
public class UserDetailsController {
	
	@Autowired
	UserDetailsServices services;
	
	@PostMapping(value="saveUserDetails")
	public ResponseEntity<Object> saveUserDetails(@RequestBody UserDetails userDetails) {
try {
	UserDetails data=services.save(userDetails);
	if (data !=null) {
		return new ResponseEntity<Object>(data,HttpStatus.OK);
		
	} else {
		return new ResponseEntity<Object>("Data Not Saved",HttpStatus.OK);

	}
		
	} catch (Exception e) {
	// TODO: handle exception
	return new ResponseEntity<Object>("Something went wrong",HttpStatus.OK);
}
	}
}
