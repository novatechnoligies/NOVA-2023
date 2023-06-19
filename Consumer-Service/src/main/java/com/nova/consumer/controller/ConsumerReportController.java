package com.nova.consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nova.consumer.dto.ConsumerReportDTO;
import com.nova.consumer.service.ConsumerReportService;

@RestController
@CrossOrigin(origins = "*")
public class ConsumerReportController {

	@Autowired
	ConsumerReportService consumerReportService;
	
	@GetMapping(value = "getConsumerReportDetails/{conId}")
	public ResponseEntity<Object> getConsumerReportDetails( @PathVariable("conId")Long conId,Long appId){
		try {
			ConsumerReportDTO report = consumerReportService.getConsumerReportDetails(conId,appId);
			if (report==null) {
				return new ResponseEntity<Object>("No Report Found", HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(report, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>("something went wrong", HttpStatus.OK);
		}
	}
	
	
}
