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

@GetMapping(value = "findAllShopDetails")
public ResponseEntity<Object> findAllShopDetails() {
	try {
		List<ShopDetails> data = detailsServices.findAllShopDetails();
		if (data != null && !data.isEmpty()) {
			return new ResponseEntity<Object>(data, HttpStatus.OK);

		} else {
			return new ResponseEntity<Object>("data not found", HttpStatus.OK);

		}

	} catch (Exception e) {
		// TODO: handle exception
		return new ResponseEntity<Object>("something went wrong", HttpStatus.OK);
	}
}

@GetMapping(value="getById/{Id}")
public ResponseEntity<Object> getById(@PathVariable("Id")Long id) {
try {
	Optional<ShopDetails>data=detailsServices.getById(id);
	if (data.isPresent()) {
		return new ResponseEntity<Object>(data.get(),HttpStatus.OK);
		
	} else {
		return new ResponseEntity<Object>("not found",HttpStatus.OK);

	}
		
	

	
} catch (Exception e) {
	// TODO: handle exception
	return new ResponseEntity<Object>("something went wrong",HttpStatus.OK);
}
}
}
