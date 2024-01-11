package com.nova.dataservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nova.dataservice.DTO.AppoinmentDetailDTO;
import com.nova.dataservice.entity.TechnicianDetails;
import com.nova.dataservice.service.TechnicianDetailsService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/dataservice")
public class TechnicianDetailsController {

	@Autowired
	TechnicianDetailsService techSer;
	
	@PostMapping(value = "saveTechnicianDetails")
	public ResponseEntity<Object> saveTechnicianDetails(@RequestBody TechnicianDetails technician) {
		try {
			TechnicianDetails data = techSer.saveTechnicianDetails(technician);
			if (data!=null) {
				return new ResponseEntity<>(data, HttpStatus.OK);
			}else {
				return new ResponseEntity<>("fail to save data", HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("somthing went wrong fail to save data , due to MYSQL is down", HttpStatus.OK);
		}
	}
	@GetMapping(value = "getTechnicianNotesByPatientIdAndTechnicianId")
	public ResponseEntity<Object> getTechnicianNotesByPatientIdAndTechnicianId(Long patientId, Long technicianId) {

		try {
			TechnicianDetails data = techSer.getTechnicianNotesByPatientIdAndTechnicianId(patientId, technicianId);
			if (data==null) {
				return new ResponseEntity<Object>("no data found", HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(data, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>("Something went wrong", HttpStatus.OK);
		}
	}
	@GetMapping(value = "getAllTechnicianNotesByAppointmentIdAndTechnicianId")
	public ResponseEntity<Object> getAllTechnicianNotesByAppointmentIdAndTechnicianId(Long appointmentId, Long technicianId) {

		try {
			List<TechnicianDetails> data = techSer.getAllTechnicianNotesByAppointmentIdAndTechnicianId(appointmentId, technicianId);
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
