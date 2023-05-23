package com.nova.dataservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping(value="findAllShopServiceRelation")
	public ResponseEntity<Object> findAllShopServiceRelation() {
		try {
			List<ShopServiceRelation> data = relationServices.findAllShopServiceRelation();
			if (data != null && !data.isEmpty()) {
				return new ResponseEntity<Object>(data, HttpStatus.OK);

			} else {
				return new ResponseEntity<Object>("data not found", HttpStatus.OK);

			}

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Object>("data not found", HttpStatus.OK);
		}

	}
	
	@GetMapping(value="shopServiceRelationfindById/(prId)")
	public ResponseEntity<Object> shopServiceRelationfindById(@PathVariable ("prId")long id) {
try {
	Optional<ShopServiceRelation> data=	relationServices.shopServiceRelationfindById(id);
	
	if (data.isPresent()) {
		return new ResponseEntity<Object>(data.get(),HttpStatus.OK);
		
	} else {
		return new ResponseEntity<Object>("data not found",HttpStatus.OK);

	}
		
	

	
} catch (Exception e) {
	// TODO: handle exception
	return new ResponseEntity<Object>("something went wrong",HttpStatus.OK);
}
}
}
