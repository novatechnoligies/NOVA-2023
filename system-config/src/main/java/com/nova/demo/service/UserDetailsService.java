package com.nova.demo.service;

import java.util.Optional;

import com.nova.demo.entity.UserDetails;

public interface UserDetailsService {

	Optional<UserDetails> getUserByUserNameAndPassword(String userName, String password);

	Optional<UserDetails> getUserDetailsByemail(String email);

	Optional<UserDetails> getUserDetailsByPhone(String phone);

	void saveUserDetails(UserDetails ud);

	Optional<UserDetails> findUserByPhoneAndOtp(String phone, String otp);

	Optional<UserDetails> findUserByEmailAndOtp(String email, String otp);



	

	

}
