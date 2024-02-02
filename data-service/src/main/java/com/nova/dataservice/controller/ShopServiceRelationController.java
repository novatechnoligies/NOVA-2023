package com.nova.dataservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nova.dataservice.DTO.ServiceDetailDTO;
import com.nova.dataservice.DTO.ServiceMasterShopRelationDTO;
import com.nova.dataservice.DTO.ServiceMasterShoplistDto;
import com.nova.dataservice.entity.ServiceMasterShopRelation;
import com.nova.dataservice.entity.ShopDetails;
import com.nova.dataservice.service.ShopServiceRelationServices;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/dataservice")
class ShopServiceRelationController {
	
	@Autowired
	ShopServiceRelationServices relationServices;
	
	
	
	@PostMapping(value = "saveShopServiceRelation")
	public ResponseEntity<Object> saveShopServiceRelation(@RequestBody ServiceMasterShopRelation serviceRelation) {
		try {
			ServiceMasterShopRelation data = relationServices.saveShopServiceRelation(serviceRelation);
			if (data != null) {
				return new ResponseEntity<Object>(data, HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>("data not saved", HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>("somthing went wrong", HttpStatus.OK);
		}
	}
	
	@GetMapping(value = "findAllShopServiceRelation")
	public ResponseEntity<Object> findAllShopServiceRelation() {
		try {
			List<ServiceMasterShopRelationDTO> data = relationServices.findAllShopServiceRelation();
			if (data != null && !data.isEmpty()) {
				return new ResponseEntity<Object>(data, HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>("data not found", HttpStatus.OK);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>("data not found", HttpStatus.OK);
		}
	}
	
	@GetMapping(value = "shopServiceRelationfindById/(prId)")
	public ResponseEntity<Object> shopServiceRelationfindById(@PathVariable("prId") long id) {
		try {
			Optional<ServiceMasterShopRelation> data = relationServices.shopServiceRelationfindById(id);
			if (data.isPresent()) {
				return new ResponseEntity<Object>(data.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>("data not found", HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>("something went wrong", HttpStatus.OK);
		}
	}

	@PostMapping(value = "saveShopServiceList")
	public ResponseEntity<Object> saveShopServiceList(@RequestBody List<ServiceMasterShopRelation> serviceRelation) {
		try {
			List<ServiceMasterShopRelation> data = relationServices.saveShopServiceList(serviceRelation);
			if (data != null) {
				return new ResponseEntity<Object>(data, HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>("data not saved", HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>("somthing went wrong", HttpStatus.OK);
		}
	}
	
	@PostMapping(value = "saveServiceListForMultiShop")
	public ResponseEntity<Object> saveServiceListForMultiShop(@RequestBody ServiceMasterShoplistDto serviceRelation) {
		try {
			ServiceMasterShoplistDto data = relationServices.saveServiceListForMultiShop(serviceRelation);
			if (data != null) {
				return new ResponseEntity<Object>(data, HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>("data not saved", HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>("somthing went wrong", HttpStatus.OK);
		}
	}
	
	@GetMapping(value = "findAllShopServiceByLab/{labId}/{service}")
	public ResponseEntity<Object> findAllShopServiceByLab(@PathVariable("labId") Long labId, @PathVariable("service") String service) {
		try {
			 List<ServiceDetailDTO> data = relationServices.findAllShopServiceByLab(labId, service);
			if (data != null && !data.isEmpty()) {
				return new ResponseEntity<Object>(data, HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>("data not found", HttpStatus.OK);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>("data not found", HttpStatus.OK);
		}
	}
	
	@GetMapping(value = "findAllShopServiceByLab/{labId}")
	public ResponseEntity<Object> findAllShopServiceByLab(@PathVariable("labId") Long labId) {
		try {
			 List<ServiceDetailDTO> data = relationServices.findAllShopServiceByLab(labId);
			if (data != null && !data.isEmpty()) {
				return new ResponseEntity<Object>(data, HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>("data not found", HttpStatus.OK);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>("data not found", HttpStatus.OK);
		}
	}
	@PatchMapping(value = "updatedServicePrice")
	public ResponseEntity<Object> updatedServicePrice(Long serviceId, Float newPrice) {
		try {
			ServiceMasterShopRelation data = relationServices.updatedServicePrice(serviceId,newPrice);
			if (data != null) {
				HashMap<String, String> map = new HashMap<>();
				map.put("200", "success");
				map.put("message", "updated");
				return new ResponseEntity<Object>(map, HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>("ServicePrice Not Found", HttpStatus.OK);
			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			return new ResponseEntity<Object>("Something went wrong", HttpStatus.OK);
		}
	}

}
