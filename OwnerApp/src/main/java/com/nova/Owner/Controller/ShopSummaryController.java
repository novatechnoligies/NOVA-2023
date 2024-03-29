package com.nova.Owner.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nova.Owner.DTO.ServiceMasterParameterDTO;
import com.nova.Owner.DTO.ShopSummaryByDTO;
import com.nova.Owner.Service.ShopSummaryService;

@RestController
@CrossOrigin(value="*")
@RequestMapping(value = "/api/v1")

public class ShopSummaryController {
	@Autowired
	ShopSummaryService service;

	@GetMapping(value = "getShopSummaryById/{id}")
	public ResponseEntity<Object> getShopSummaryById(@PathVariable("id") Long shop_id) {
		try {
			List<ShopSummaryByDTO> data = service.getShopSummaryById(shop_id);
			if (data != null) {
				return new ResponseEntity<Object>(data, HttpStatus.OK);

			} else {
				return new ResponseEntity<Object>("Data Not Found", HttpStatus.OK);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<Object>("Something Went Wrong", HttpStatus.OK);
		}
	}

	@GetMapping(value = "getByServiceMasterName/{id}")
	public ResponseEntity<Object> getByServiceMasterName(@PathVariable("id") Long serviceMasterId) {
		try {

			List<ServiceMasterParameterDTO> data = service.getByServiceMasterName(serviceMasterId);
			if (data != null) {
				return new ResponseEntity<Object>(data, HttpStatus.OK);

			} else {
				return new ResponseEntity<Object>(data, HttpStatus.OK);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<Object>("something went wrong", HttpStatus.OK);
		}
	}

}

