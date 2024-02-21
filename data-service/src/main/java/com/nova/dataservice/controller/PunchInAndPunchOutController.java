package com.nova.dataservice.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nova.dataservice.DTO.UserDetailsDTO;
import com.nova.dataservice.entity.PunchInAndPunchOut;
import com.nova.dataservice.entity.ShopDetails;
import com.nova.dataservice.service.PunchInAndPunchOutService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/dataservice")
public class PunchInAndPunchOutController<punchIn> {
	
	@Autowired
	PunchInAndPunchOutService punchInAndPunchOutService;
	
	@PostMapping(value="/savePunchIn")
	public ResponseEntity<Object> savePunchIn(@RequestBody PunchInAndPunchOut punchIn) {
		try {
			PunchInAndPunchOut data = punchInAndPunchOutService.SavePunchIn(punchIn);
			if (data!=null) {
				return new ResponseEntity<>(data, HttpStatus.OK);
			}else {
				return new ResponseEntity<>("fail to save data", HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("somthing went wrong fail to save data , due to MYSQL is down", HttpStatus.OK);
		}
	}
	@PutMapping(value = "/updatedById")
	public ResponseEntity<Object> updatedById(Long id) {
    
		try {
			Optional<PunchInAndPunchOut> data = punchInAndPunchOutService.updatedById(id);
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
	@PutMapping(value = "updatedPunchOutByEmployeeIdAndDate")
	public ResponseEntity<Object> updatedPunchOutByEmployeeIdAndDate(Long employeeId,LocalDate date) {
		try {
			PunchInAndPunchOut data = punchInAndPunchOutService.updatedPunchOutByEmployeeIdAndDate(employeeId, date);
			if (data != null) {
				HashMap<String, String> map = new HashMap<>();
				map.put("200", "success");
				map.put("message", "updated");
				return new ResponseEntity<Object>(map, HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>("punchOut Not Found", HttpStatus.OK);
			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			return new ResponseEntity<Object>("Something went wrong", HttpStatus.OK);
		}
	}
}