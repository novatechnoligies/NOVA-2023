package com.nova.dataservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nova.dataservice.entity.Locations;
import com.nova.dataservice.entity.MasterInventory;
import com.nova.dataservice.service.MasterInventoryService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/dataservice")
public class MasterInventoryController {
	
	@Autowired
	MasterInventoryService inventoryService;
	
	
	
	
	@PostMapping(value = "saveMasterInventory")
	public ResponseEntity<Object> saveMasterInventory(@RequestBody MasterInventory inventory) {
		try {
			MasterInventory data = inventoryService.saveMasterInventory(inventory);
			if (data!=null) {
				return new ResponseEntity<>(data, HttpStatus.OK);
			}else {
				return new ResponseEntity<>("fail to save data", HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("somthing went wrong fail to save data , due to MYSQL is down", HttpStatus.OK);
		}
	}

}
