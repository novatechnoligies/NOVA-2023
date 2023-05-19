package com.nova.dataservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nova.dataservice.entity.ShopAvalibility;
import com.nova.dataservice.service.ShopsAvilabilityService;

@RestController
public class ShopsAvailabilityController {
	
	@Autowired
	ShopsAvilabilityService avilabilityService;
	
	@PostMapping(value="saveShopAvailability")
	public ResponseEntity<Object> saveShopAvailability(@RequestBody ShopAvalibility avalibility ) {
	 try {
		 ShopAvalibility data=	avilabilityService.saveShopAvailability(avalibility);
			if (data!=null) {
				return new ResponseEntity<Object>(data,HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>("save failed",HttpStatus.OK);
			}
	} catch (Exception e) {
		return new ResponseEntity<Object>("Something went wrong",HttpStatus.OK);
	}
	}

}
