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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nova.dataservice.DTO.ShopDetailsDTO;
import com.nova.dataservice.DTO.UserDetailsDTO;
import com.nova.dataservice.entity.ShopDetails;
import com.nova.dataservice.service.ShopDetailsService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/dataservice")
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
			e.printStackTrace();
			// TODO: handle exception
			return new ResponseEntity<Object>("Something went wrong", HttpStatus.OK);
		}

	}
	@GetMapping("findAllShopDetails")
	public ResponseEntity<Object> findAllShopDetails() {
		try {
			List<ShopDetailsDTO> data = detailsService.findAllShopDetails();
			if (data != null && !data.isEmpty()) {
				return new ResponseEntity<Object>(data, HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>("shopDetails Not Found", HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>("something went wrong", HttpStatus.OK);
		}
	}

	@GetMapping(value = "/findByIdShopDetails/{prId}")
	public ResponseEntity<Object> findByIdShopDetails(@PathVariable("prId") Long id) {
		try {
			Optional<ShopDetailsDTO> data = detailsService.findByIdShopDetails(id);
			if (data.isPresent()) {
				return new ResponseEntity<Object>(data.get(), HttpStatus.OK);

			} else {
				return new ResponseEntity<Object>("incorrect Id", HttpStatus.OK);

			}

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>("something went wrong", HttpStatus.OK);
		}
	}
	@GetMapping(value = "searchLabByName")
	public ResponseEntity<Object> searchLabByNameAndOwner(String labName, Long ownerId) {
    
		try {
			List<ShopDetailsDTO> data = detailsService.searchLabByNameAndOwner(labName, ownerId);
			if (data.isEmpty()) {
				return new ResponseEntity<Object>("no data found", HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(data, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
		return new ResponseEntity<Object>("Something went wrong",HttpStatus.OK);
	}
		
	}

}
