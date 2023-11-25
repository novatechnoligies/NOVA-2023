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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nova.dataservice.DTO.LocationsDTO;
import com.nova.dataservice.entity.Locations;
import com.nova.dataservice.entity.Role;
import com.nova.dataservice.service.LocationService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/dataservice")
public class LocationController {
	
	@Autowired
	LocationService lService;
	
	@PostMapping(value = "saveLocations")
	public ResponseEntity<Object> saveLocation(@RequestBody Locations location) {
		try {
			Locations data = lService.saveLocation(location);
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
	@GetMapping(value = "getLocation")
	public ResponseEntity<Object> getAllLocation() {
		
		List<Locations> data = lService.getLocation();
		if (data.isEmpty()) {
			return new ResponseEntity<Object>("no data found", HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(data, HttpStatus.OK);
		}
	}
	
	@GetMapping(value = "getLocationById/{id}")
	public ResponseEntity<Object> findLocationsByOrgId(@PathVariable("id") Long id) {
		LocationsDTO data = lService.findLocationsByOrgId(id);
		if (data!=null) {
			return new ResponseEntity<Object>(data,HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>("no data found for this id",HttpStatus.OK);
		}
		
	}
	}


