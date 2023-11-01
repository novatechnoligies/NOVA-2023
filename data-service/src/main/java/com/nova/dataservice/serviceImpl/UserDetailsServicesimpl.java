package com.nova.dataservice.serviceImpl;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nova.dataservice.DTO.UserDetailsDTO;
import com.nova.dataservice.entity.Role;
import com.nova.dataservice.entity.UserDetails;
import com.nova.dataservice.repository.RoleRepo;
import com.nova.dataservice.repository.UserDetailsRepository;
import com.nova.dataservice.service.UserDetailsServices;
import com.nova.dataservice.utils.OtpUtils;

@Service
public class UserDetailsServicesimpl implements UserDetailsServices {
	
	@Autowired
	UserDetailsRepository detailsRepository;
	
	@Autowired
	RoleRepo roleRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDetails saveUserDetails(UserDetails userDetails) {
		userDetails.setStatus(true);
		userDetails.setIsDeleted(false);
		userDetails.setCreatedAt(LocalDate.now());
		userDetails.setIsPhoneNoVerified(false);
		Optional<Role> role = roleRepo.findById(userDetails.getRole().getId());
		if (role.isPresent()) {
			userDetails.setRole(role.get());
		}
		return detailsRepository.save(userDetails);
	}

	@Override
	public List<UserDetailsDTO> getAllUserDetails() {
		List<UserDetails> userDetailsList = detailsRepository.findAll(); // Retrieve a list of UserDetails entities
		
		List<UserDetailsDTO> userDetailsDTOList = userDetailsList.stream()
		    .map(userDetails -> modelMapper.map(userDetails, UserDetailsDTO.class))
		    .collect(Collectors.toList());
		return userDetailsDTOList;
	}

	@Override
	public UserDetailsDTO getUserDetailsById(Long id) {
		UserDetailsDTO userDetailsDTO = modelMapper.map(detailsRepository.findById(id).get(), UserDetailsDTO.class);
		return userDetailsDTO;
	}

	@Override
	public List<UserDetailsDTO> getAllUserDetailsOfOwner(String ownerName) {
		List<UserDetails> userDetailsList = detailsRepository.findByFirstName(ownerName); // Retrieve a list of UserDetails entities
		
		List<UserDetailsDTO> userDetailsDTOList = userDetailsList.stream()
		    .map(userDetails -> modelMapper.map(userDetails, UserDetailsDTO.class))
		    .collect(Collectors.toList());
		return userDetailsDTOList;
	}
	
	@Override
	public UserDetailsDTO getUserByUserNameAndPassword(String userName, String password) {
		UserDetailsDTO userDetailsDTO = modelMapper.map(detailsRepository.findByUsernameAndPassword(userName,password).get(), UserDetailsDTO.class);

		return userDetailsDTO;
	}

	@Override
	public UserDetailsDTO getUserDetailsByemail(String email) {
		Optional<UserDetails> data = detailsRepository.findByEmail(email);
		if (data.isPresent()) {
			int otp = OtpUtils.generateOtp();
			UserDetails ud = data.get();
			ud.setOtp(otp + "");
			detailsRepository.save(ud);
		} 
		// write Logic here to send opt mail
		
		UserDetailsDTO userDetailsDTO = modelMapper.map(data.get(), UserDetailsDTO.class);

		return userDetailsDTO;
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
