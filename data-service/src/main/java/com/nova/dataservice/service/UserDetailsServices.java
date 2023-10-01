package com.nova.dataservice.service;


import java.util.List;
import java.util.Optional;


import com.nova.dataservice.entity.UserDetails;

public interface UserDetailsServices {

	UserDetails saveUserDetails(UserDetails userDetails);

	List<UserDetails> getAllUserDetails();

	Optional<UserDetails> getUserDetailsById(Long id);

	List<UserDetails> getAllConsumerDetailsById(Long id);


}
