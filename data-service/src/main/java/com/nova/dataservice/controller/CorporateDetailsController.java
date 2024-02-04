package com.nova.dataservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nova.dataservice.entity.CorporateDetails;
import com.nova.dataservice.service.CorporateDetailService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/dataservice")

public class CorporateDetailsController {
	
	@Autowired
	CorporateDetailService corporateDetailService;
	
	@PostMapping(value="saveCorporateDetails")
	public ResponseEntity<CorporateDetails> saveCorporateDetails(@RequestBody CorporateDetails corporateDetails) {
	CorporateDetails details= corporateDetailService.saveCorporateDetails(corporateDetails);
		try {
			if (details!=null) {
			 return new ResponseEntity<CorporateDetails>(details,HttpStatus.OK);
				
		} else {
			return new ResponseEntity<CorporateDetails>(HttpStatus.BAD_REQUEST);
		}
			
		} catch (Exception e) {
			return new ResponseEntity<CorporateDetails>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
