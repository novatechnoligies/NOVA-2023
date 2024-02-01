package com.nova.dataservice.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nova.dataservice.DTO.AppoinmentDetailDTO;
import com.nova.dataservice.entity.LabReportLocatiosn;
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
	@GetMapping(value = "getAllReportsByAppointmentId")
	public ResponseEntity<Object> getAllReportsByAppointmentId(Long appointmentId) {

		try {
			List<LabReportLocatiosn> data = docSer.getAllReportsByAppointmentId(appointmentId);
			if (data.isEmpty()) {
				return new ResponseEntity<Object>("no data found", HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(data, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>("Something went wrong", HttpStatus.OK);
		}
	}
}



