package com.nova.dataservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nova.dataservice.entity.ShopDetails;
import com.nova.dataservice.service.ShopDetailsServices;

@RestController
public class ShopDetailsController {
	@Autowired
	ShopDetailsServices detailsServices;
	
	@PostMapping(value="saveShopDetails")
	public ResponseEntity<Object> saveShopDetails(@RequestBody ShopDetails details) {
try {
	ShopDetails data=detailsServices.saveShopDetails(details);
	if (data!=null) {
		return new ResponseEntity<Object>(data,HttpStatus.OK);
		
		
	} else {
		return new ResponseEntity<Object>("Details Not Found",HttpStatus.OK);

	}
		
	

	
} catch (Exception e) {
	// TODO: handle exception
	return new ResponseEntity<Object>("Details enterd wrong",HttpStatus.OK);
}

}
}
