package com.nova.consumer.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nova.consumer.dto.ConsumerAppoinemtDTO;
import com.nova.consumer.dto.ConsumerReportDTO;
import com.nova.consumer.service.ConsumerReportService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/consumerservice")
public class ConsumerAppointment {

	@Autowired
	ConsumerReportService consumerReportService;
	
	@GetMapping(value = "getConsumerAppontmentDetails")
	public ResponseEntity<Object> getConsumerAppontmentDetails(LocalDate fromDate,LocalDate toDate){
		try {
			List<ConsumerAppoinemtDTO> report = consumerReportService.getConsumerAppontmentDetails(fromDate,toDate);
			if (report==null) {
				return new ResponseEntity<Object>("No Report Found", HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(report, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>("something went wrong", HttpStatus.OK);
		}
	}
}
