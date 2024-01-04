package com.nova.dataservice.controller;

import java.time.LocalDate;
import java.util.List;

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

import com.nova.dataservice.DTO.AppoinmentDTO;
import com.nova.dataservice.DTO.TrackingDTO;
import com.nova.dataservice.entity.EmployeTracking;
import com.nova.dataservice.service.EmployeTrackingService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/employeTrackingService")
public class EmployeTrackingController {

	@Autowired
	EmployeTrackingService employeTrackingService;
	
	@PostMapping(value = "saveEmployeTracking")
	public ResponseEntity<Object> saveEmployeTracking(@RequestBody EmployeTracking employeTracking) {
		try {
			EmployeTracking data = employeTrackingService.saveEmployeTracking(employeTracking);
			if (data!=null) {
				return new ResponseEntity<>(data, HttpStatus.OK);
			}else {
				return new ResponseEntity<>("fail to save data", HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("somthing went wrong fail to save data , due to MYSQL is down", HttpStatus.OK);
		}
	}

	/*
	 * @GetMapping(value = "getEmployeDataByEmpIdAndDateRange") public
	 * ResponseEntity<Object>
	 * getEmployeDataByEmpIdAndDateRange(@PathVariable("empId") Long
	 * empId,@PathVariable("fromDate") LocalDate fromDate ,@PathVariable LocalDate
	 * toDate) {
	 * 
	 * try { List<EmployeTracking> data =
	 * employeTrackingService.getEmployeDataByEmpIdAndDateRange(empId, fromDate,
	 * toDate); if (data.isEmpty()) { return new
	 * ResponseEntity<Object>("no data found", HttpStatus.OK); } else { return new
	 * ResponseEntity<Object>(data, HttpStatus.OK); } } catch (Exception e) {
	 * e.printStackTrace(); return new
	 * ResponseEntity<Object>("Something went wrong", HttpStatus.OK); } }
	 */
	
	@GetMapping(value = "/getEmployeeDetailsByShopIdAndOwnerId")
	public ResponseEntity<Object> getEmployeeDetailsByShopIdAndOwnerId(@PathVariable("shopId") Long shopId,@PathVariable ("ownerId") Long ownerId){
		try {
			List<TrackingDTO> trackingData = employeTrackingService.getEmployeeDetailsByShopIdAndOwnerId(shopId,ownerId);
			if (trackingData!= null && !trackingData.isEmpty()) {
				return new ResponseEntity<Object>(trackingData,HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>("fail to get tracking data",HttpStatus.OK);
			}
		} catch (Exception e) {
			// TODO: handle exception
		return new ResponseEntity<Object>("something went wrong while fetching the data",HttpStatus.OK);
		}
	}
}
