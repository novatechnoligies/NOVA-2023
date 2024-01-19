package com.nova.dataservice.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nova.dataservice.entity.InventoryShopRelation;
import com.nova.dataservice.entity.Locations;
import com.nova.dataservice.service.InventoryShopRelationService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/dataservice")

public class InventoryShopRelationController {
	
	@Autowired
	InventoryShopRelationService relationService;
	

	@PostMapping(value = "saveInventoryShopRelation")
	public ResponseEntity<Object> saveInventoryShopRelationController(@RequestBody InventoryShopRelation inventoryShopRelation) {
		try {
			InventoryShopRelation data = relationService.saveInventoryShopRelationController(inventoryShopRelation);
			if (data!=null) {
				return new ResponseEntity<>(data, HttpStatus.OK);
			}else {
				return new ResponseEntity<>("fail to save the Inventory Shop Relation", HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("somthing went wrong fail to save data , due to MYSQL is down", HttpStatus.OK);
		
		}

}
	
	

	@PostMapping(value = "uploadInventoryShopRelationByCsv")
	public ResponseEntity<Object> uploadInventoryShopRelationByCsv(@RequestParam("file")  MultipartFile inventoryFile) {
		try {
		    boolean data = relationService.uploadInventoryShopRelationByCsv(inventoryFile);

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
