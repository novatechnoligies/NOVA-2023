package com.nova.dataservice.controller;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
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

import com.nova.dataservice.DTO.ServiceMasterShopRelationDTO;
import com.nova.dataservice.entity.ServiceMasterShopRelation;
import com.nova.dataservice.service.ShopServiceRelationServices;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/v1")
class ShopServiceRelationController {
	
	@Autowired
	ShopServiceRelationServices relationServices;
	
	
	
	@PostMapping(value = "saveShopServiceRelation")
	public ResponseEntity<Object> saveShopServiceRelation(@RequestBody ServiceMasterShopRelation serviceRelation) {
		try {
			ServiceMasterShopRelation data =	relationServices.saveShopServiceRelation(serviceRelation);
			if (data!=null) {
				return new ResponseEntity<Object>(data,HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>("data not saved",HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>("somthing went wrong",HttpStatus.OK);
		}
	}
	
	@GetMapping(value="findAllShopServiceRelation")
	public ResponseEntity<Object> findAllShopServiceRelation() {
		try {
			List<ServiceMasterShopRelationDTO> data = relationServices.findAllShopServiceRelation();
			if (data != null && !data.isEmpty()) {
				return new ResponseEntity<Object>(data, HttpStatus.OK);

			} else {
				return new ResponseEntity<Object>("data not found", HttpStatus.OK);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<Object>("data not found", HttpStatus.OK);
		}

	}
	
	@GetMapping(value="shopServiceRelationfindById/(prId)")
	public ResponseEntity<Object> shopServiceRelationfindById(@PathVariable ("prId")long id) {
try {
	Optional<ServiceMasterShopRelation> data=	relationServices.shopServiceRelationfindById(id);
	
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
