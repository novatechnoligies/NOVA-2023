package com.nova.dataservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	@GetMapping(value="findAllShopType")
	public ResponseEntity<Object> findAllShopType() {
try {
	List<ShopType>data=	services.findAllShopType();
	if (data!=null && !data.isEmpty()) {
		return new ResponseEntity<Object>(data,HttpStatus.OK);
		
		
	} else {
		return new ResponseEntity<Object>("data not found",HttpStatus.OK);

	}
	
} catch (Exception e) {
	// TODO: handle exception
	return new ResponseEntity<Object>("something went wrong",HttpStatus.OK);
}
	
}

@GetMapping(value = "getShopTypeId/(prId)")
public ResponseEntity<Object> getShopTypeId(@PathVariable("prId") Long id) {

try {
	Optional<ShopType> data = services.getShopTypeId(id);
	if (data.isPresent()) {
		return new ResponseEntity<Object>(data.get(), HttpStatus.OK);

	} else {
		return new ResponseEntity<Object>("Data Not Found", HttpStatus.OK);

	}

} catch (Exception e) {
	// TODO: handle exception
	return new ResponseEntity<Object>("Something went wrong", HttpStatus.OK);
}

}
}
