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

import com.nova.dataservice.entity.Pramotions;
import com.nova.dataservice.entity.Role;
import com.nova.dataservice.service.PromotionsServices;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/v1")
public class PromotionController {
	
	@Autowired
	PromotionsServices service;
	@PostMapping(value="Savepromotion")
	public ResponseEntity<Object> Savepromotion( @RequestBody Pramotions pramotions) {
	try {
		 Pramotions data=service.Savepromotion(pramotions);
		 if (data !=null ) {
			 return new ResponseEntity<>(data,HttpStatus.OK);
			
		}else {
			return new ResponseEntity<Object>("data not saved ",HttpStatus.OK);
		}
		
	} catch (Exception e) {
		// TODO: handle exception
		return new ResponseEntity<Object>("Something Went Wrong",HttpStatus.OK);
	}
		}
	
	@GetMapping(value="/getPromotions")
	public ResponseEntity<Object> getPromotions() {
		try {
			List<Pramotions> data = service.findAllPromotions();
			if (data != null && !data.isEmpty()) {
				return new ResponseEntity<Object>(data, HttpStatus.OK);

			} else {
				return new ResponseEntity<Object>("not found", HttpStatus.OK);

			}

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Object>("wrong", HttpStatus.OK);
		}

	}
	@GetMapping("/getPromotionById/{prId}")
	public ResponseEntity<Object> getPromotionById(@PathVariable("prId") Long id) {
		try {
			Optional<Pramotions> data = service.getPromotionById(id);
			if (data.isPresent()) {
				return new ResponseEntity<Object>(data.get(), HttpStatus.OK);

			} else {
				return new ResponseEntity<Object>("user not found ById", HttpStatus.OK);

			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Object>("user not found", HttpStatus.OK);
		}

	}

}
