package com.nova.dataservice.serviceImpl;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.dataservice.entity.UserDetails;
import com.nova.dataservice.repository.UserDetailsRepository;
import com.nova.dataservice.service.UserDetailsServices;
// mallesh Service
@Service
public class UserDetailsServicesimpl implements UserDetailsServices {
	
	@Autowired
	UserDetailsRepository detailsRepository;

	@Override
	public UserDetails saveUserDetails(UserDetails userDetails) {
		userDetails.setStatus(true);
		userDetails.setIsDeleted(false);
		userDetails.setCreatedAt(LocalDate.now());
		return detailsRepository.save(userDetails);
	}

	@Override
	public List<UserDetails> getAllUserDetails() {
		// TODO Auto-generated method stub
		return detailsRepository.findAll();
	}

	@Override
	public Optional<UserDetails> getUserDetailsById(Long id) {
		// TODO Auto-generated method stub
		return detailsRepository.findById(id);
	}

	@Override
	public List<UserDetails> getAllUserDetailsOfOwner(String ownerName) {
		// TODO Auto-generated method stub
		return detailsRepository.findByFirstName(ownerName);
	}

}
