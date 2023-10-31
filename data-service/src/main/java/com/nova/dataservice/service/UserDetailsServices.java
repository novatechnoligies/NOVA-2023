package com.nova.dataservice.service;


import java.util.List;
import java.util.Optional;


import com.nova.dataservice.entity.UserDetails;

public interface UserDetailsServices {

	UserDetails saveUserDetails(UserDetails userDetails);

	List<UserDetails> getAllUserDetails();

	Optional<UserDetails> getUserDetailsById(Long id);

	List<UserDetails> getAllUserDetailsOfOwner(String ownerName);

	Optional<UserDetails> getUserByUserNameAndPassword(String userName, String password);

	Optional<UserDetails> getUserDetailsByemail(String email);

	Optional<UserDetails> getUserDetailsByPhone(String phone);

	Optional<UserDetails> findUserByPhoneAndOtp(String phone, String otp);

	Optional<UserDetails> findUserByEmailAndOtp(String email, String otp);

	Optional<UserDetails> findUserByPhone(String phone);

}
