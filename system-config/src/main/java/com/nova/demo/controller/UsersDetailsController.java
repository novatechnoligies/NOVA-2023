package com.nova.demo.controller;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nova.demo.entity.UserDetails;
import com.nova.demo.service.UserDetailsService;

@RestController
public class UsersDetailsController {

	@Autowired
	UserDetailsService detailsService;

	@PostMapping(value = "getUserByUserNameAndPassword")
	public ResponseEntity<Object> getUserByUserNameAndPassword(String userName, String password) {
		try {
			Optional<UserDetails> data = detailsService.getUserByUserNameAndPassword(userName, password);
			if (data.isPresent()) {
				return new ResponseEntity<Object>(data.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>("username/password not found", HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>("somthing went wrong", HttpStatus.OK);
		}
	}

	@GetMapping(value = "/generateOtpForEmailVerification/{email}")
	public ResponseEntity<Object> getUserDetailsByemail(@PathVariable("email") String email) {
		try {
			Optional<UserDetails> data = detailsService.getUserDetailsByemail(email);
			if (data.isPresent()) {
				int otp = generateOtp();
				UserDetails ud = data.get();
				ud.setOtp(otp + "");
				detailsService.saveUserDetails(ud);
				return new ResponseEntity<Object>(data.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>("not register email in our database", HttpStatus.OK);
			}

		} catch (Exception e) {
			return new ResponseEntity<Object>("somthing went wrong", HttpStatus.OK);
		}
	}

	@GetMapping(value = "/generateOtpForPhoneVerification/{phone}")
	public ResponseEntity<Object> getUserDetailsByPhone(@PathVariable("phone") String phone) {
		try {
			Optional<UserDetails> data = detailsService.getUserDetailsByPhone(phone);
			if (data.isPresent()) {

				int otp = generateOtp();
				UserDetails ud = data.get();
				ud.setOtp(otp + "");
				detailsService.saveUserDetails(ud);
				return new ResponseEntity<Object>(data.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>("not register phone in our database", HttpStatus.OK);
			}

		} catch (Exception e) {
			return new ResponseEntity<Object>("somthing went wrong", HttpStatus.OK);
		}
	}

	public int generateOtp() {
		Random random = new Random();
		int randomNumber = random.nextInt(900000) + 100000;
		return randomNumber;

	}

	@GetMapping(value = "/verifyOtpByPhoneAndOtp/{phone}/{otp}")
	public ResponseEntity<Object> findUserByPhoneAndOtp(@PathVariable("phone") String phone,
			@PathVariable("otp") String otp) {
		try {
			Optional<UserDetails> data = detailsService.findUserByPhoneAndOtp(phone, otp);
			if (data.isPresent()) {
				return new ResponseEntity<Object>(data.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>("enter valida phone and otp", HttpStatus.OK);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Object>("something went wrong", HttpStatus.OK);
		}
	}

	@GetMapping(value = "/verifyEmail/{email}/{otp}")
	public ResponseEntity<Object> findUserByEmailAndOtp(@PathVariable("email") String email,
			@PathVariable("otp") String otp) {
		try {
			Optional<UserDetails> data = detailsService.findUserByEmailAndOtp(email, otp);
			if (data.isPresent()) {
				return new ResponseEntity<Object>(data.get(), HttpStatus.OK);

			} else {
				return new ResponseEntity<Object>("enter Valid Email and otp", HttpStatus.OK);

			}

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Object>("someThing went Wrong", HttpStatus.OK);
		}

	}
	@GetMapping(value="/updtaePasswordByPhone/{phone}/{otp}/{password}")
	public ResponseEntity<Object> updatePasswordByPhone(@PathVariable("phone") String phone,@PathVariable("otp") String otp,@PathVariable ("password")String password) {
	try {
		Optional<UserDetails> data = detailsService.findUserByPhoneAndOtp(phone,otp);
		if (data.isPresent()) {
			UserDetails ud= data.get();
			ud.setPassword(password);
			detailsService.saveUserDetails(ud);
			return new ResponseEntity<Object>("password updated successfully",HttpStatus.OK);
			
		} else {
			return new ResponseEntity<Object>("phoneNumber not Valid",HttpStatus.OK);

		}
		
	} catch (Exception e) {
		// TODO: handle exception
		return new ResponseEntity<Object>("Something Went wrong",HttpStatus.OK);
	}
	}
	@GetMapping(value="/updtaePasswordByEmail/{email}/{otp}/{password}")
	public ResponseEntity<Object> updtaePasswordByEmail(@PathVariable("email")String email,@PathVariable("otp") String otp,@PathVariable("password")String password) {
	try {
		Optional<UserDetails>data =	detailsService.findUserByEmailAndOtp(email, otp);
		if (data.isPresent()) {
		UserDetails ud=	data.get();
		ud.setPassword(password);
		detailsService.saveUserDetails(ud);
		return new ResponseEntity<Object>("password updated successfully",HttpStatus.OK);
			
		} else {
			return new ResponseEntity<Object>("enter Valid Email",HttpStatus.OK);

		}
		
	} catch (Exception e) {
		// TODO: handle exception
		return new ResponseEntity<Object>("Something went wrong",HttpStatus.OK);
	}
	}
	
	@GetMapping(value = "getUserByPhone/{phone}")
	public ResponseEntity<Object> findUserByPhone(@PathVariable("phone") String phone) {
	 Optional<UserDetails> data=	detailsService.findUserByPhone(phone);
	 return new ResponseEntity<Object>(data, HttpStatus.OK);
	}
}

