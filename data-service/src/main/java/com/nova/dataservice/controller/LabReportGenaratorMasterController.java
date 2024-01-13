package com.nova.dataservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nova.dataservice.DTO.LabMasterDTO;
import com.nova.dataservice.service.LabReportGenaratorMasterService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/dataservice")
public class LabReportGenaratorMasterController {

	@Autowired
	LabReportGenaratorMasterService labReportGenaratorMasterService;
	
	@GetMapping(value = "labReportGenaratorMaster")
	public ResponseEntity<Object> labReportGenaratorMaster(Long testId) {
		LabMasterDTO labMasterDTO=	labReportGenaratorMasterService.labReportGenaratorMaster(testId);
		
		return new ResponseEntity<Object>(labMasterDTO,HttpStatus.OK);
	}
}
