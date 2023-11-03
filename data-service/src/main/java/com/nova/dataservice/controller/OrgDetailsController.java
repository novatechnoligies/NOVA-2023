package com.nova.dataservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nova.dataservice.DTO.OrganizationDTO;

import com.nova.dataservice.entity.Locations;
import com.nova.dataservice.entity.Organization;
import com.nova.dataservice.entity.Pramotions;

import com.nova.dataservice.entity.Organization;
import com.nova.dataservice.entity.UserDetails;

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
	
//	@Query(nativeQuery = true, value ="Select * from user_details as c where c.first_name like %:ownerName%")
//	List<UserDetails> findByFirstName(@Param("ownerName")String ownerName);
	

	@GetMapping(value = "searchOrgsByName")
	public ResponseEntity<Object> searchOrgsByName(String orgName) {
		try {
			List<OrganizationDTO> data = orgDetailsService.searchOrgsByName(orgName);
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

	@GetMapping(value = "getAllOrgList")
	public ResponseEntity<Object> getAllOrgList() {
		try {
			List<Organization> data = orgDetailsService.getAllOrgList();
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
	@GetMapping(value = "getOrgListByOwnerId")
	public ResponseEntity<Object> getOrgListByOwnerId(Long ownerId) {
		try {
			List<Organization> data = orgDetailsService.getOrgListByOwnerId(ownerId);
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
	

}
