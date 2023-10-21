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

import com.nova.dataservice.entity.MasterParameterSubParameter;
import com.nova.dataservice.service.MasterParameterSubParameterService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/v1")
public class MasterParameterSubParameterController {
	
	@Autowired
	MasterParameterSubParameterService masterParameterSubParameterService;
	
	@PostMapping(value = "saveMasterParameterSubParameter")
	public ResponseEntity<Object> saveMasterParameterSubParameter(@RequestBody MasterParameterSubParameter masterParameterSubParameter){
		try {
			MasterParameterSubParameter data = masterParameterSubParameterService.saveMasterParameterSubParameter(masterParameterSubParameter);
			if (data != null) {
				return  new ResponseEntity<>(data, HttpStatus.OK); 
			}else {
				return new ResponseEntity<Object>("fail to save data", HttpStatus.OK);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Object>("something went wrong", HttpStatus.OK);
		}
	}
	
	@GetMapping(value = "getAllMasterParameterSubParameter")
	 private ResponseEntity<Object> getAllMasterParameterSubParameter(){
		List<MasterParameterSubParameter> data = masterParameterSubParameterService.getAllMasterParameterSubParameter();
		if (data.isEmpty()) {
			return new ResponseEntity<Object>("no data found", HttpStatus.OK);
		}else {
			return new ResponseEntity<Object>(data,HttpStatus.OK);
		}
	 }

	@GetMapping(value = "getMasterParameterSubParameterById/{id}")
	private ResponseEntity<Object> getMasterParameterSubParameterById(@PathVariable ("id") Long id){
	Optional<MasterParameterSubParameter> data = masterParameterSubParameterService.getMasterParameterSubParameterById(id);
	if (data.isPresent()) {
		return new ResponseEntity<Object>(data.get(),HttpStatus.OK);
	}else {
		return new ResponseEntity<Object>("no data found",HttpStatus.OK);
		}
	}
}
	 


