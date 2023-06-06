package com.nova.demo.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nova.demo.DTO.AppShopConsumerOwnerDetails;
import com.nova.demo.DTO.AppointmentCountDetails;
import com.nova.demo.service.AppConOwnShopService;

@RestController
public class AppConOwnShopController {

	@Autowired
	AppConOwnShopService appConOwnShopService;

	@GetMapping(value = "getAllAppoinmentByShopIdAndDate")
	public ResponseEntity<Object> getAllAppoinmentByShopIdAndDate(Long shopId, LocalDate date) {
		try {
			List<AppShopConsumerOwnerDetails> data = appConOwnShopService.getAllAppoinmentByShopIdAndDate(shopId, date);

			if (!data.isEmpty()) {

				return new ResponseEntity<Object>(data, HttpStatus.OK);

			} else {
				return new ResponseEntity<Object>("no Appoinments Found", HttpStatus.OK);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<Object>("something went wrong", HttpStatus.OK);
		}

	}
	@GetMapping(value="getTotalAppointmentCount")
	public ResponseEntity<Object> getTotalAppointmentCount(Long shopId,String appoinmentStatus, LocalDate fromDate,LocalDate toDate) {
		
		try {
			AppointmentCountDetails data= appConOwnShopService.getTotalAppointmentCount(shopId,appoinmentStatus,fromDate,toDate);
			if (data!=null) {

				return new ResponseEntity<Object>(data, HttpStatus.OK);

			} else {
				return new ResponseEntity<Object>("no Appoinments Found", HttpStatus.OK);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<Object>("something went wrong", HttpStatus.OK);
		}
		
	}
}
