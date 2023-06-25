package com.nova.demo.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nova.demo.DTO.AppShopConsumerOwnerDetails;
import com.nova.demo.DTO.AppointmentCountDetails;
import com.nova.demo.DTO.ShopDetailsDTO;
import com.nova.demo.entity.ShopDetails;
import com.nova.demo.service.AppConOwnShopService;

@RestController
@CrossOrigin(origins = "*")
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
	@GetMapping(value = "getShopDetailsByShopTypeID")
	public ResponseEntity<Object> getShopDetailsByShopTypeID(Long shopTypeID) {
		
		List<ShopDetailsDTO> list = appConOwnShopService.getShopDetailsByShopTypeID(shopTypeID);
		if (list.isEmpty()) {
			return new ResponseEntity<>("No shops are availabale", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(list,HttpStatus.OK);
		}
	}
	
	@GetMapping(value = "getShopDetailsAndAppointmentCountsAndOwnerDetailsByShopId")
	public ResponseEntity<Object> getShopDetailsAndAppointmentCountsAndOwnerDetailsByShopId(Long shopId,LocalDate fromDate, LocalDate toDate) {
		ShopDetailsDTO data = appConOwnShopService.getShopDetailsAndAppointmentCountsAndOwnerDetailsByShopId(shopId,fromDate,toDate);
		if (data==null) {
			return new ResponseEntity<>("No shops are availabale", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(data,HttpStatus.OK);
		}
	}
}
