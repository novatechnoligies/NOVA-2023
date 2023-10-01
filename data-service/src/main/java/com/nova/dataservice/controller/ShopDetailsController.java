package com.nova.dataservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nova.dataservice.entity.ShopDetails;
import com.nova.dataservice.service.ShopDetailsService;

@RestController
@CrossOrigin(origins = "*")
public class ShopDetailsController {
	@Autowired
	ShopDetailsService detailsService;

	@PostMapping(value = "saveShopDetails")
	public ResponseEntity<Object> saveShopDetails(@RequestBody ShopDetails details) {
		try {
			ShopDetails data = detailsService.saveShopDetails(details);
			if (data != null) {
				return new ResponseEntity<Object>(data, HttpStatus.OK);

			} else {
				return new ResponseEntity<Object>("ShopDetails Not Found", HttpStatus.OK);

			}

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Object>("Something went wrong", HttpStatus.OK);
		}

	}
	@GetMapping(value="/searchLabDetailsByIdAndName/{labId}/{labName}")
	public ResponseEntity<Object> searchLabDetailsByIdAndName(@PathVariable ("labId") Long id,@PathVariable ("labName")String namePattern) {
		try {
		List<ShopDetails>data=detailsService.searchLabDetailsByIdAndName(id,namePattern);
		if (data != null && !data.isEmpty( )) {
			return new ResponseEntity<Object>(data, HttpStatus.OK);

		} else {
			return new ResponseEntity<Object>("shopDetails Not Found", HttpStatus.OK);

		}

	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		return new ResponseEntity<Object>("something went wrong", HttpStatus.OK);
	}

}
		
	@GetMapping("findAllShopDetails")
	public ResponseEntity<Object> findAllShopDetails() {
		try {
			List<ShopDetails> data = detailsService.findAllShopDetails();
			if (data != null && data.isEmpty()) {
				return new ResponseEntity<Object>(data, HttpStatus.OK);

			} else {
				return new ResponseEntity<Object>("shopDetails Not Found", HttpStatus.OK);

			}

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Object>("something went wrong", HttpStatus.OK);
		}

	}

	@GetMapping(value = "/findByIdShopDetails/{prId}")
	public ResponseEntity<Object> findByIdShopDetails(@PathVariable("prId") Long id) {
		try {
			Optional<ShopDetails> data = detailsService.findByIdShopDetails(id);
			if (data.isPresent()) {
				return new ResponseEntity<Object>(data.get(), HttpStatus.OK);

			} else {
				return new ResponseEntity<Object>("incorrect Id", HttpStatus.OK);

			}

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Object>("something went wrong", HttpStatus.OK);
		}
	}

}
