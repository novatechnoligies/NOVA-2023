package com.nova.dataservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nova.dataservice.entity.ShopUpdateRequest;
import com.nova.dataservice.service.ShopUpdateRequestService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/dataservice")
public class ShopUpdatedRequestController {
	@Autowired
	ShopUpdateRequestService requestService;

	@PostMapping(name = "shopUpdatedRequest")
	public ResponseEntity<Object> shopUpdatedRequest(@RequestBody ShopUpdateRequest request) {
		try {
			ShopUpdateRequest data = requestService.saveShopUpdateRequest(request);
			if (data != null) {
				return new ResponseEntity<Object>("Save Success", HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>("Not Saved ", HttpStatus.OK);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Object>("something went wrong ", HttpStatus.OK);
		}
	}
}
