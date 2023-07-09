package com.nova.Owner.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nova.Owner.DTO.AppointmentDetails;
import com.nova.Owner.DTO.AppointmentDetailsDTO;
import com.nova.Owner.DTO.ShopDetailsDTO;
import com.nova.Owner.Entity.ShopDetails;
import com.nova.Owner.Entity.UserDetails;
import com.nova.Owner.Service.OwnerOREmployeeService;

@RestController
public class OwnerController {
	@Autowired
	OwnerOREmployeeService employeeService;

	@PostMapping(value = "createOwnerOREmployee")
	public ResponseEntity<Object> createOwnerOREmployee(@RequestBody UserDetails details) {
		try {
			UserDetails ud = employeeService.createOwnerOREmployee(details);
			if (ud != null) {
				return new ResponseEntity<Object>("Save Data Successfull", HttpStatus.CREATED);
			} else {
				return new ResponseEntity<Object>("not Cretaed", HttpStatus.CREATED);
			}

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Object>("Something went wrong", HttpStatus.CREATED);
		}

	}
	@PostMapping(value = "findOwnerByUserNameAndPassword")
	public ResponseEntity<Object> findOwnerByUserNameAndPassword(String userName,String password) {
		try {
			Optional<UserDetails> data= employeeService.findOwnerByUserNameAndPassword(userName,password);
			if (data.isPresent()) {
				return new ResponseEntity<Object>(data.get(), HttpStatus.FOUND);
			} else {
				return new ResponseEntity<Object>("Invalid Username And Password", HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Object>("Something went wrong", HttpStatus.OK);

		}
	}
	
	@GetMapping(value = "findOwnerByPhoneNumber/{userPhone}")
	public ResponseEntity<Object> findOwnerByPhoneNumber(@PathVariable("userPhone")String ownerPhone ) {
		try {
			Optional<UserDetails> data= employeeService.findOwnerByPhoneNumber(ownerPhone);
			if (data.isPresent()) {
				return new ResponseEntity<Object>(data.get(), HttpStatus.FOUND);
			} else {
				return new ResponseEntity<Object>("Invalid Username And Password", HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Object>("Something went wrong", HttpStatus.OK);

		}
	}
	
	@GetMapping(value = "findOwnerByEmail")
	public ResponseEntity<Object> findOwnerByEmail(String email ) {
		try {
			Optional<UserDetails> data= employeeService.findOwnerByEmail(email);
			if (data.isPresent()) {
				return new ResponseEntity<Object>(data.get(), HttpStatus.FOUND);
			} else {
				return new ResponseEntity<Object>("no user found on this mail", HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Object>("Something went wrong", HttpStatus.OK);

		}
	}
		
		@GetMapping(value="GetShopDetailsByOwnerId/{ownerId}")
		public ResponseEntity<Object> GetShopDetailsByOwnerId(@PathVariable("ownerId") Long ownerId) {
			try {
				List<ShopDetailsDTO> data = employeeService.GetShopDetailsByOwnerId(ownerId);
				if (data != null) {
					return new ResponseEntity<Object>(data, HttpStatus.OK);

				} else {
					return new ResponseEntity<Object>("id Not Found", HttpStatus.OK);

				}

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return new ResponseEntity<Object>("something went wrong", HttpStatus.OK);
			}
		}
		
		@GetMapping(value="GetAppoinemetByShopId/{shopId}")
		public ResponseEntity<Object> GetAppoinemetByShopId(@PathVariable ("shopId") Long shopid) {
			try {
				List<AppointmentDetailsDTO> data = employeeService.GetAppoinemetByShopId(shopid);
				if (data != null) {
					return new ResponseEntity<Object>(data, HttpStatus.OK);
				} else {
					return new ResponseEntity<Object>("id Not Found", HttpStatus.OK);
				}
			} catch (Exception e) {
			// TODO: handle exception
				e.printStackTrace();
				return new ResponseEntity<Object>("something went wrong", HttpStatus.OK);
		}

			
		}
		@GetMapping(value="GetAppointmentDetailsByAppointmentId/{AppointmentId}")
		public ResponseEntity<Object> GetAppointmentDetailsByAppointmentId(@PathVariable ("AppointmentId") Long appointmentId){
			 try {
				    List<AppointmentDetails> data=  employeeService.GetAppointmentDetailsByAppointmentId(appointmentId);
				 	if (!data.isEmpty()) {
						return new ResponseEntity<Object>(data, HttpStatus.OK);
					} else {
						return new ResponseEntity<Object>("id is Not Found", HttpStatus.OK);
					}
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<Object>("somethin went wrong", HttpStatus.OK);
			}
		}
}
