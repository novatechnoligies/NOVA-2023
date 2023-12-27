package com.nova.dataservice.controller;

import java.time.LocalDate;
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

import com.nova.dataservice.DTO.SlotAvailabilityDTO;
import com.nova.dataservice.entity.SlotAvailability;
import com.nova.dataservice.service.SlotAvailabilityServices;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/dataservice")
public class SlotAvailabilityController {

	@Autowired
	SlotAvailabilityServices availabilityServices;
	
	@PostMapping(value = "saveSlotAvailability")
	public ResponseEntity<Object> saveSlotAvailability(@RequestBody SlotAvailability slotAvailability) {
		try {
			SlotAvailability data = availabilityServices.saveSlotAvailability(slotAvailability);
			if (data!=null) {
				return new ResponseEntity<>(data, HttpStatus.OK);
			}else {
				return new ResponseEntity<>("fail to save data", HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("somthing went wrong fail to save data , due to MYSQL is down", HttpStatus.OK);
		}
	}
	
	@GetMapping(value = "getAllSlotAvailability")
	public ResponseEntity<Object> getAllSlotAvailability() {
		List<SlotAvailability> data = availabilityServices.getAllSlotAvailability();
		if (data.isEmpty()) {
			return new ResponseEntity<Object>("no data found", HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(data, HttpStatus.OK);
		}
	}
	
	@GetMapping(value = "getSlotAvailabilityById/{id}")
	public ResponseEntity<Object> getSlotAvailabilityById(@PathVariable("id") Long id) {
		Optional<SlotAvailability> data = availabilityServices.getSlotAvailabilityById(id);
		if (data.isPresent()) {
			return new ResponseEntity<Object>(data.get(),HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>("no data found for this id",HttpStatus.OK);
		}
		
	}
	
	@GetMapping(value = "getAllSlotAvailabilityByLabIdAndDate")
	public ResponseEntity<Object> getAllSlotAvailabilityByLabIdAndDate(LocalDate date, Long labId) {
		List<SlotAvailabilityDTO> data = availabilityServices.getAllSlotAvailabilityByLabIdAndDate(date, labId);
		if (data.isEmpty()) {
			return new ResponseEntity<Object>("no data found", HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(data, HttpStatus.OK);
		}
	}


}

	
	

