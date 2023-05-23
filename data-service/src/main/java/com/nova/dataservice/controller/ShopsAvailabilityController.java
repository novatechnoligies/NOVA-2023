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

import com.nova.dataservice.entity.ShopAvalibility;
import com.nova.dataservice.service.ShopsAvilabilityService;

@RestController
public class ShopsAvailabilityController {

	@Autowired
	ShopsAvilabilityService avilabilityService;

	@PostMapping(value = "saveShopAvailability")
	public ResponseEntity<Object> saveShopAvailability(@RequestBody ShopAvalibility avalibility) {
		try {
			ShopAvalibility data = avilabilityService.saveShopAvailability(avalibility);
			if (data != null) {
				return new ResponseEntity<Object>(data, HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>("save failed", HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>("Something went wrong", HttpStatus.OK);
		}
	}

	@GetMapping("value=findAllShopAvailability")
	public ResponseEntity<Object> findAllShopAvailability() {
		try {
			List<ShopAvalibility> data = avilabilityService.findAllShopAvailability();
			if (data != null && !data.isEmpty()) {
				return new ResponseEntity<Object>(data, HttpStatus.OK);

			} else {
				return new ResponseEntity<Object>("ShopAvalibility not Found", HttpStatus.OK);

			}

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Object>("Error Found", HttpStatus.OK);
		}

	}

	@GetMapping("value=getShopAvaibilityById/{prId}")
	public ResponseEntity<Object> getShopAvaibilityById(@PathVariable("prId") long id) {
		try {
			Optional<ShopAvalibility> data = avilabilityService.getShopAvaibilityById(id);
			if (data.isPresent()) {
				return new ResponseEntity<Object>(data.get(), HttpStatus.OK);

			} else {
				return new ResponseEntity<Object>("user not found ById", HttpStatus.OK);

			}

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Object>("not Found", HttpStatus.OK);
		}
	}
}
