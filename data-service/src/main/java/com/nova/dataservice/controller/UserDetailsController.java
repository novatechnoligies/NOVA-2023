package com.nova.dataservice.controller;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.nova.dataservice.entity.Role;
import com.nova.dataservice.entity.UserDetails;
import com.nova.dataservice.service.RoleService;

import com.nova.dataservice.service.UserDetailsServices;

@RestController
@CrossOrigin(origins = "*")
public class UserDetailsController {
	
	@Autowired
	UserDetailsServices detailsServices;
	
	@PostMapping(value = "saveUserDetails")
	public ResponseEntity<Object> saveUserDetails(@RequestBody UserDetails userDetails) {
		try {
			UserDetails data = detailsServices.saveUserDetails(userDetails);
			if (data!=null) {
				return new ResponseEntity<>(data, HttpStatus.OK);
			}else {
				return new ResponseEntity<>("fail to save data", HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("somthing went wrong fail to save data , due to MYSQL is down", HttpStatus.OK);
		}
	}
	
	@GetMapping(value = "getAllUserDetails")
	public ResponseEntity<Object> getAllUserDetails() {
    
		List<UserDetails> data = detailsServices.getAllUserDetails();
		if (data.isEmpty()) {
			return new ResponseEntity<Object>("no data found", HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(data, HttpStatus.OK);
		}
	}
	@GetMapping(value = "/getAllConsumerDetailsById/{roleId}")
	 public ResponseEntity<Object> getAllConsumerDetailsById(@PathVariable ("roleId") Long id) {
		 List<UserDetails> data= detailsServices.getAllConsumerDetailsById (id);
		 if (data.isEmpty()) {
				return new ResponseEntity<Object>("no Consumer Data", HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(data, HttpStatus.OK);
			}
		
	}
	
	@GetMapping(value = "getUserDetailsById/{id}")
	public ResponseEntity<Object> getUserDetailsById(@PathVariable("id") Long id) {
    	try {
		Optional<UserDetails> data = detailsServices.getUserDetailsById(id);
		if (data.isPresent()) {
			return new ResponseEntity<Object>(data.get(),HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>("no data found for this id",HttpStatus.OK);
		}
	} catch (Exception e) {
	// TODO: handle exception
	return new ResponseEntity<Object>("Something went wrong",HttpStatus.OK);
}
	}
}
