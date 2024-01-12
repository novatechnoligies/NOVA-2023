package com.nova.dataservice.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nova.dataservice.service.LabReportLocationService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/dataservice")
public class LabReportLocation {

	@Autowired
	LabReportLocationService docSer;
	
	@PostMapping("/uploadLabReportLocation")
	public ResponseEntity<String> uploadLabReportLocation(@RequestParam("file") MultipartFile file,
			@RequestParam("patientId") Long patientId, @RequestParam("labId") Long labId,
			@RequestParam("technicianId") Long technicianId, @RequestParam("appointmentId") Long appointmentId) {

		try {
			docSer.uploadLabReportLocation(file, patientId, labId, technicianId, appointmentId);
			return ResponseEntity.ok("File uploaded successfully.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload the file.");
		}
	}

}



