package com.nova.dataservice.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Random;

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

import com.nova.dataservice.DTO.UserDetailsDTO;
import com.nova.dataservice.entity.Role;
import com.nova.dataservice.entity.UserDetails;
import com.nova.dataservice.service.RoleService;

import com.nova.dataservice.service.UserDetailsServices;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/dataservice")
public class UserDetailsController {

	@Autowired
	UserDetailsServices detailsServices;

	@PostMapping(value = "saveUserDetails")
	public ResponseEntity<Object> saveUserDetails(@RequestBody UserDetails userDetails) {
		try {
			UserDetails data = detailsServices.saveUserDetails(userDetails);
			if (data != null) {
				return new ResponseEntity<>(data, HttpStatus.OK);
			} else {
				return new ResponseEntity<>("fail to save data", HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("somthing went wrong fail to save data , due to MYSQL is down", HttpStatus.OK);
		}
	}

	@GetMapping(value = "getAllUserDetails")
	public ResponseEntity<Object> getAllUserDetails() {

		List<UserDetailsDTO> data = detailsServices.getAllUserDetails();
		if (data.isEmpty()) {
			return new ResponseEntity<Object>("no data found", HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(data, HttpStatus.OK);
		}
	}

	@GetMapping(value = "searchOwnerByName")
	public ResponseEntity<Object> getAllUserDetailsOfOwner(String ownerName) {

		try {
			List<UserDetailsDTO> data = detailsServices.getAllUserDetailsOfOwner(ownerName);
			if (data.isEmpty()) {
				return new ResponseEntity<Object>("no data found", HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(data, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>("Something went wrong", HttpStatus.OK);
		}

	}

	@GetMapping(value = "getUserDetailsById/{id}")
	public ResponseEntity<Object> getUserDetailsById(@PathVariable("id") Long id) {
		try {
			UserDetailsDTO data = detailsServices.getUserDetailsById(id);
			if (data != null) {
				return new ResponseEntity<Object>(data, HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>("no data found for this id", HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>("Something went wrong", HttpStatus.OK);
		}
	}

	@PostMapping(value = "getUserByUserNameAndPassword")
	public ResponseEntity<Object> getUserByUserNameAndPassword(String username, String password) {
		try {
			UserDetailsDTO data = detailsServices.getUserByUserNameAndPassword(username, password);
			if (data != null) {
				return new ResponseEntity<Object>(data, HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>("username/password not found", HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>("somthing went wrong", HttpStatus.OK);
		}
	}

	@GetMapping(value = "/sendOtpToEmailForForgetPassword/{email}")
	public ResponseEntity<Object> getUserDetailsByemail(@PathVariable("email") String email) {
		try {
			UserDetailsDTO userDetailsDTO = detailsServices.getUserDetailsByemail(email);
			if (userDetailsDTO != null) {
				return new ResponseEntity<Object>(userDetailsDTO, HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>("not register email in our database", HttpStatus.OK);
			}

		} catch (Exception e) {
			return new ResponseEntity<Object>("somthing went wrong", HttpStatus.OK);
		}
	}

//	@GetMapping(value = "/generateOtpForPhoneVerification/{phone}")
//	public ResponseEntity<Object> getUserDetailsByPhone(@PathVariable("phone") String phone) {
//		try {
//			Optional<UserDetails> data = detailsServices.getUserDetailsByPhone(phone);
//			if (data.isPresent()) {
//
//				int otp = generateOtp();
//				UserDetails ud = data.get();
//				ud.setOtp(otp + "");
//				detailsServices.saveUserDetails(ud);
//				return new ResponseEntity<Object>(data.get(), HttpStatus.OK);
//			} else {
//				return new ResponseEntity<Object>("not register phone in our database", HttpStatus.OK);
//			}
//
//		} catch (Exception e) {
//			return new ResponseEntity<Object>("somthing went wrong", HttpStatus.OK);
//		}
//	}

//	public int generateOtp() {
//		Random random = new Random();
//		int randomNumber = random.nextInt(900000) + 100000;
//		return randomNumber;
//
//	}

//	@GetMapping(value = "/verifyOtpByPhoneAndOtp/{phone}/{otp}")
//	public ResponseEntity<Object> findUserByPhoneAndOtp(@PathVariable("phone") String phone,
//			@PathVariable("otp") String otp) {
//		try {
//			Optional<UserDetails> data = detailsServices.findUserByPhoneAndOtp(phone, otp);
//			if (data.isPresent()) {
//				return new ResponseEntity<Object>(data.get(), HttpStatus.OK);
//			} else {
//				return new ResponseEntity<Object>("enter valida phone and otp", HttpStatus.OK);
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			return new ResponseEntity<Object>("something went wrong", HttpStatus.OK);
//		}
//	}

	@GetMapping(value = "/verifyEmail/{email}/{otp}")
	public ResponseEntity<Object> findUserByEmailAndOtp(@PathVariable("email") String email,
			@PathVariable("otp") String otp) {
		try {
			Optional<UserDetails> data = detailsServices.findUserByEmailAndOtp(email, otp);
			HashMap<String, Boolean> map = new HashMap<>();
			if (data.isPresent()) {
				map.put("isVerified", true);
				return new ResponseEntity<Object>(map, HttpStatus.OK);

			} else {
				map.put("isVerified", false);
				return new ResponseEntity<Object>(map, HttpStatus.OK);

			}

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Object>("someThing went Wrong", HttpStatus.OK);
		}

	}

//	@GetMapping(value="/updtaePasswordByPhone/{phone}/{otp}/{password}")
//	public ResponseEntity<Object> updatePasswordByPhone(@PathVariable("phone") String phone,@PathVariable("otp") String otp,@PathVariable ("password")String password) {
//	try {
//		Optional<UserDetails> data = detailsServices.findUserByPhoneAndOtp(phone,otp);
//		if (data.isPresent()) {
//			UserDetails ud= data.get();
//			ud.setPassword(password);
//			detailsServices.saveUserDetails(ud);
//			return new ResponseEntity<Object>("password updated successfully",HttpStatus.OK);
//			
//		} else {
//			return new ResponseEntity<Object>("phoneNumber not Valid",HttpStatus.OK);
//
//		}
//		
//	} catch (Exception e) {
//		// TODO: handle exception
//		return new ResponseEntity<Object>("Something Went wrong",HttpStatus.OK);
//	}
//	}
	@GetMapping(value = "/updtaePasswordByEmail/{email}/{otp}/{password}")
	public ResponseEntity<Object> updtaePasswordByEmail(@PathVariable("email") String email,
			@PathVariable("otp") String otp, @PathVariable("password") String password) {
		try {
			Optional<UserDetails> data = detailsServices.findUserByEmailAndOtp(email, otp);
			HashMap<String, Boolean> map = new HashMap<>();
			if (data.isPresent()) {
				UserDetails ud = data.get();
				ud.setPassword(password);
				detailsServices.saveUserDetails(ud);
				map.put("updaed", true);
				return new ResponseEntity<Object>(map, HttpStatus.OK);

			} else {
				map.put("updaed", true);
				return new ResponseEntity<Object>(map, HttpStatus.OK);

			}

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Object>("Something went wrong", HttpStatus.OK);
		}
	}

	@GetMapping(value = "getConsumerByPhone/{phone}")
	public ResponseEntity<Object> getConsumerByPhone(@PathVariable("phone") String phone) {
		List<UserDetailsDTO> data = detailsServices.getConsumerByPhone(phone);
		return new ResponseEntity<Object>(data, HttpStatus.OK);
	}

	@GetMapping(value = "getAllUserDetailsByCreadtedBy")
	public ResponseEntity<Object> getAllUserDetailsByCreadtedBy(Long userId) {

		List<UserDetailsDTO> data = detailsServices.getAllUserDetailsByCreadtedBy(userId);
		if (data.isEmpty()) {
			return new ResponseEntity<Object>(new ArrayList<>(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(data, HttpStatus.OK);
		}
	}

	@GetMapping(value = "searchOwnerByNameAndCreatedByAndStatus")
	public ResponseEntity<Object> searchOwnerByNameAndCreatedByAndStatus(String ownerName, Long createdBy,
			boolean status) {

		try {
			List<UserDetailsDTO> data = detailsServices.getAllUserDetailsOfOwner(ownerName);
			List<UserDetailsDTO> data1 = detailsServices.searchOwnerByNameAndCreatedByAndStatus(ownerName, createdBy,
					status);
			if (data.isEmpty()) {
				return new ResponseEntity<Object>("no data found", HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(data, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>("Something went wrong", HttpStatus.OK);
		}

	}



	@GetMapping(value = "getConsumerByUsername/{username}")
	public ResponseEntity<Object> getConsumerByUsername(@PathVariable("username") String username) {
		List<UserDetailsDTO> data = detailsServices.getConsumerByUsername(username);
		return new ResponseEntity<Object>(data, HttpStatus.OK);
	}
}
