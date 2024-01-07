package com.nova.dataservice.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nova.dataservice.DTO.PatientDetailsDTO;
import com.nova.dataservice.service.AppointmentDetailservice;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/dataservice")
public class PatientDetailsController {
	
	@Autowired
	AppointmentDetailservice apSer;

	@GetMapping(value = "getPatientDetailsByAppointmentId")
	public ResponseEntity<Object> getPatientDetailsByAppointmentId(Long appointmentId) {

		try {
			  PatientDetailsDTO data = apSer.getPatientDetailsByAppointmentId(appointmentId);
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
}
