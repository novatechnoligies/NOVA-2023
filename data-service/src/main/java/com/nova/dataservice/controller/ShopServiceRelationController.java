package com.nova.dataservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nova.dataservice.entity.ShopServiceRelation;
import com.nova.dataservice.service.ShopServiceRelationServices;

@RestController
class ShopServiceRelationController {
	
	@Autowired
	ShopServiceRelationServices relationServices;
	
	@PostMapping(value = "saveShopServiceRelation")
	public ResponseEntity<Object> saveShopServiceRelation(@RequestBody ShopServiceRelation serviceRelation) {
		try {
			ShopServiceRelation data =	relationServices.saveShopServiceRelation(serviceRelation);
			if (data!=null) {
				return new ResponseEntity<Object>(data,HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>("data not saved",HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>("somthing went wrong",HttpStatus.OK);
		}
	}

}
