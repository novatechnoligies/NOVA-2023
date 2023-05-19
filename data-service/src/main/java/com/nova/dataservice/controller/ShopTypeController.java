package com.nova.dataservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nova.dataservice.entity.ShopType;
import com.nova.dataservice.service.ShopTypeServices;

@RestController
public class ShopTypeController {
	@Autowired
	ShopTypeServices services;
	@PostMapping(value="saevShopType")
	public ResponseEntity<Object> saveShopType(@RequestBody ShopType shopType) {
		try {
			ShopType data =	services.saveShopType(shopType);
			if (data!=null) {
				return new ResponseEntity<Object>(data, HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>("failed", HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>("somthing went wrong", HttpStatus.OK);
		}
	}

}
