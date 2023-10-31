package com.nova.dataservice.serviceImpl;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.dataservice.entity.UserDetails;
import com.nova.dataservice.repository.UserDetailsRepository;
import com.nova.dataservice.service.UserDetailsServices;

@Service
public class UserDetailsServicesimpl implements UserDetailsServices {
	
	@Autowired
	UserDetailsRepository detailsRepository;

	@Override
	public UserDetails saveUserDetails(UserDetails userDetails) {
		userDetails.setStatus(true);
		userDetails.setIsDeleted(false);
		userDetails.setCreatedAt(LocalDate.now());
		userDetails.setIsPhoneNoVerified(false);
		return detailsRepository.save(userDetails);
	}

	@Override
	public List<UserDetails> getAllUserDetails() {
		return detailsRepository.findAll();
	}

	@Override
	public Optional<UserDetails> getUserDetailsById(Long id) {
		return detailsRepository.findById(id);
	}

	@Override
	public List<UserDetails> getAllUserDetailsOfOwner(String ownerName) {
		return detailsRepository.findByFirstName(ownerName);
	}
	
	@Override
	public Optional<UserDetails> getUserByUserNameAndPassword(String userName, String password) {
		return detailsRepository.findByUsernameAndPassword(userName,password);
	}

	@Override
	public Optional<UserDetails> getUserDetailsByemail(String email) {
		return detailsRepository.findByEmail(email);
	}

	@Override
	public Optional<UserDetails> getUserDetailsByPhone(String phone) {
		return detailsRepository.findByPhone(phone);
	}


	@Override
	public Optional<UserDetails> findUserByPhoneAndOtp(String phone, String otp) {
		return detailsRepository.findUserByPhoneAndOtp(phone,otp);
	}

	@Override
	public Optional<UserDetails> findUserByEmailAndOtp(String email, String otp) {
		return detailsRepository.findUserByEmailAndOtp(email,otp);
	}

	@Override
	public Optional<UserDetails> findUserByPhone(String phone) {
		return detailsRepository.findByPhone(phone);
	}

}
