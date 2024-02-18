package com.nova.dataservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
	
	
	@PostMapping(value = "uploadCorporateeUsersByCsv")
	public ResponseEntity<Object> uploadCorporateUsersByCsv(@RequestParam("file")  MultipartFile file) {
		try {
		    boolean data = corporateDetailService.uploadCorporateeUsersByCsv(file);

		    if (data) {
		        return new ResponseEntity<>(data, HttpStatus.OK);
		    } else {
		        return new ResponseEntity<>("Failed to save data", HttpStatus.OK);
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		    return new ResponseEntity<>("Something went wrong; failed to save data due to MYSQL being down", HttpStatus.OK);
		}

}
}
