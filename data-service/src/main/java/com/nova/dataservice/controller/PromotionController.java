package com.nova.dataservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties.Http;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nova.dataservice.entity.Pramotions;
import com.nova.dataservice.entity.Role;
import com.nova.dataservice.service.PromotionsServices;

@RestController
public class PromotionController {
	
	@Autowired
	PromotionsServices Service;
	@PostMapping(value="Savepromotion")
	public ResponseEntity<Object> Savepromotion( @RequestBody Pramotions pramotions) {
	try {
		 Pramotions data=Service.Savepromotion(pramotions);
		 if (data !=null ) {
			 return new ResponseEntity<>(data,HttpStatus.OK);
			
		}else {
			return new ResponseEntity<Object>("data not saved ",HttpStatus.OK);
		}
		
	} catch (Exception e) {
		// TODO: handle exception
		return new ResponseEntity<Object>("Something Went Wrong",HttpStatus.OK);
	}
		
		 
	}
}
