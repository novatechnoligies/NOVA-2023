package com.nova.dataservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nova.dataservice.entity.Organization;
import com.nova.dataservice.service.OrgDetailsService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/v1")
public class OrgDetailsController {
	
	@Autowired
	OrgDetailsService orgDetailsService;
	
	@PostMapping(value = "saveOrgDetails")
	public ResponseEntity<Object> saveOrgDetails(@RequestBody Organization details) {
		try {
			Organization data = orgDetailsService.saveOrgDetails(details);
			if (data != null) {
				return new ResponseEntity<Object>(data, HttpStatus.OK);

			} else {
				return new ResponseEntity<Object>("ShopDetails Not Found", HttpStatus.OK);

			}

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>("Something went wrong", HttpStatus.OK);
		}

	}

}
