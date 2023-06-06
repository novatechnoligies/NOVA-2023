package com.nova.dataservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nova.dataservice.entity.Role;
import com.nova.dataservice.entity.ServiceMaster;
import com.nova.dataservice.service.RoleService;
import com.nova.dataservice.service.ServiceMasterService;

@RestController
public class ServiceMasterController {

	
	@Autowired
	ServiceMasterService serviceMasterService;
	
	@PostMapping(value = "saveServiceMaster")
	public ResponseEntity<Object> saveServiceMaster(@RequestBody ServiceMaster serviceMaster) {
		try {
			ServiceMaster data = serviceMasterService.saveServiceMaster(serviceMaster);
			if (data!=null) {
				return new ResponseEntity<>(data, HttpStatus.OK);
			}else {
				return new ResponseEntity<>("fail to save data", HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("somthing went wrong fail to save data , due to MYSQL is down", HttpStatus.OK);
		}
	}
	
	@GetMapping(value = "findAllMaster")
	public ResponseEntity<Object> findAllMaster() {
		List<ServiceMaster> data = serviceMasterService.findAllMaster();
		if (data.isEmpty()) {
			return new ResponseEntity<Object>("no data found", HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(data, HttpStatus.OK);
		}
	}
	
	@GetMapping(value = "getMasterById/{id}")
	public ResponseEntity<Object> getMasterById(@PathVariable("id") Long id) {
		Optional<ServiceMaster> data = serviceMasterService.getMasterById(id);
		if (data.isPresent()) {
			return new ResponseEntity<Object>(data.get(),HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>("no data found for this id",HttpStatus.OK);
		}
		
	}

}
