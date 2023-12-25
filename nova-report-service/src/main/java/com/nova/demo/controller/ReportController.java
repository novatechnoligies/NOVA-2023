package com.nova.demo.controller;

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

import com.nova.demo.DTO.ReportFormatDTO;
import com.nova.demo.entity.Report;
import com.nova.demo.reportService.ReportService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(value="/reportService")
public class ReportController {
	
	@Autowired
	ReportService reportService;
	
	@PostMapping(value = "saveReport") 
    public ResponseEntity<Object>saveReport(@RequestBody Report report){
	  
	  try { 
		  Report data = reportService.saveReport(report); 
		  if (data!= null) {
			  return new ResponseEntity<>(data,HttpStatus.OK); 
		  } else { 
			  return new ResponseEntity<>("fail to save data", HttpStatus.OK); 
			  } 
		  } catch (Exception e){
			  return new ResponseEntity<>("something went wrong fail to save data, due to MYSQL is down",HttpStatus.OK); 
	} 
}
	 
	@GetMapping(value = "/getParametersByTestId/{ssrId}/{labId}")
	public ResponseEntity<Object> getParametersByTestId(@PathVariable("ssrId")  Long ssrId ,@PathVariable ("labId") Long labId){
		try {
			List<ReportFormatDTO>data = reportService.getParametersByTestId(ssrId,labId);
			if (data != null && !data.isEmpty()) {
				return new ResponseEntity<Object>(data,HttpStatus.OK);
			}else {
				return new ResponseEntity<Object>("fail to get the data",HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>("something went wrong while fetching the data",HttpStatus.BAD_GATEWAY);
		}
	}
}
