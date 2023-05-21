package com.nova.dataservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nova.dataservice.entity.SlotAvailability;
import com.nova.dataservice.service.SlotAvailabilityServices;

@RestController
public class SlotAvailabilityController {
	
	
	@Autowired
	SlotAvailabilityServices services;
	
	@PostMapping(value="saveSlotAvailability")
	public ResponseEntity<Object> saveSlotAvailability(@RequestBody SlotAvailability availability) {
	try {
	SlotAvailability data= services.save(availability);
		
		if (data !=null) {
			return new ResponseEntity<Object>(data,HttpStatus.OK);
			
		} else {
			return new ResponseEntity<Object>("Failed to saveData",HttpStatus.OK);

		}
		
	} catch (Exception e) {
		// TODO: handle exception
		return new ResponseEntity<Object>("someThing went wrong ",HttpStatus.OK);
	}
}
}

	
	

