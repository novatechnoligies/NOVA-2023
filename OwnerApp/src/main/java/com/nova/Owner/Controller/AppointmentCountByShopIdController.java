package com.nova.Owner.Controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nova.Owner.DTO.AppointmentCountByShopIdDTO;
import com.nova.Owner.DTO.ShopDetailsDTO;
import com.nova.Owner.DTO.TodayAppointmentCountDTO;
import com.nova.Owner.Service.AppointmentCountByShopIdService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/v1")

public class AppointmentCountByShopIdController {
	@Autowired
	AppointmentCountByShopIdService appointmentCountByShopIdService;
	
	
	@GetMapping(value="appointmentCountByShopId/{id}")
	public ResponseEntity<Object> AppointmentCountByShopId(@PathVariable("id") Long appointmentCountByShopId) {
		try {
			AppointmentCountByShopIdDTO data = appointmentCountByShopIdService.AppointmentCountByShopId(appointmentCountByShopId);
			if (data!=null) {
				return new ResponseEntity<Object>(data, HttpStatus.CREATED);
			} else {
				return new ResponseEntity<Object>("not Cretaed", HttpStatus.CREATED);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<Object>("Something went wrong", HttpStatus.CREATED);
		}
		
	}

	@GetMapping(value = "todayAppointmentCount/{id}/{todayDate}")
	public ResponseEntity<Object> todayAppointmentCount(@PathVariable("id") Long shopid,
			@PathVariable("todayDate") LocalDate todayDate) {
		try {
			TodayAppointmentCountDTO data = appointmentCountByShopIdService.todayAppointmentCount(shopid, todayDate);
			if (data != null) {
				return new ResponseEntity<Object>(data, HttpStatus.OK);

			} else {
				return new ResponseEntity<Object>("not Found", HttpStatus.OK);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<Object>("something went wrong", HttpStatus.OK);
		}
	}
	@GetMapping(value="getAppointmentCountForShopBetweenTwoDates/{shopId}/{fromDate}/{toDate}")
	public ResponseEntity<Object> getAppointmentCountForShopBetweenTwoDates(@PathVariable("shopId") Long shopId,@PathVariable("fromDate") LocalDate fromDate,@PathVariable("toDate") LocalDate toDate ) {
		try {
		TodayAppointmentCountDTO data=	appointmentCountByShopIdService.getAppointmentCountForShopBetweenTwoDates(shopId,fromDate,toDate);
		
		if (data!=null) {
			return new ResponseEntity<Object>(data,HttpStatus.OK);
			
		} else {
			return new ResponseEntity<Object>("not Found",HttpStatus.OK);

		}	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<Object>("something went wrong",HttpStatus.OK);
		}
		
	}
	@GetMapping(value="getLabCountByShopTypeId/{id}")
	public ResponseEntity<Object> getLabCountByShopTypeId(@PathVariable("id") Long shop_type_id) {
try {
	ShopDetailsDTO data=	appointmentCountByShopIdService.getLabCountByShopTypeId(shop_type_id);
	if (data!=null) {
		return new ResponseEntity<Object>(data,HttpStatus.OK);
	} else {
		return new ResponseEntity<Object>(data,HttpStatus.OK);
   }
		
} catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
	return new ResponseEntity<Object>("something went wrong",HttpStatus.OK);
}

}
}

