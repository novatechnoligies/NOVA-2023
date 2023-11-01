package com.nova.dataservice.service;


import java.util.List;
import java.util.Optional;

import com.nova.dataservice.DTO.UserDetailsDTO;
import com.nova.dataservice.entity.UserDetails;

public interface UserDetailsServices {

	UserDetails saveUserDetails(UserDetails userDetails);

	List<UserDetailsDTO> getAllUserDetails();

	UserDetailsDTO getUserDetailsById(Long id);

	List<UserDetailsDTO> getAllUserDetailsOfOwner(String ownerName);

	UserDetailsDTO getUserByUserNameAndPassword(String userName, String password);

	UserDetailsDTO getUserDetailsByemail(String email);

	Optional<UserDetails> getUserDetailsByPhone(String phone);

	Optional<UserDetails> findUserByPhoneAndOtp(String phone, String otp);

	Optional<UserDetails> findUserByEmailAndOtp(String email, String otp);

	Optional<UserDetails> findUserByPhone(String phone);

}
