package com.nova.demo.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.demo.entity.UserDetails;
import com.nova.demo.repository.UserDetailsRepo;
import com.nova.demo.service.UserDetailsService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserDetailsRepo detailsRepo;

	@Override
	public Optional<UserDetails> getUserByUserNameAndPassword(String userName, String password) {
		// TODO Auto-generated method stub
		return detailsRepo.findByUserNameAndPassword(userName,password);
	}

	@Override
	public Optional<UserDetails> getUserDetailsByemail(String email) {
		// TODO Auto-generated method stub
		return detailsRepo.findByEmail(email);
	}

	@Override
	public Optional<UserDetails> getUserDetailsByPhone(String phone) {
		// TODO Auto-generated method stub
		return detailsRepo.findByPhone(phone);
	}

	@Override
	public void saveUserDetails(UserDetails ud) {
		// TODO Auto-generated method stub
		 detailsRepo.save(ud);
		
	}

	@Override
	public Optional<UserDetails> findUserByPhoneAndOtp(String phone, String otp) {
		// TODO Auto-generated method stub
		return detailsRepo.findUserByPhoneAndOtp(phone,otp);
	}

	@Override
	public Optional<UserDetails> findUserByEmailAndOtp(String email, String otp) {
		// TODO Auto-generated method stub
		return detailsRepo.findUserByEmailAndOtp(email,otp);
	}

	@Override
	public Optional<UserDetails> findUserByPhone(String phone) {
		// TODO Auto-generated method stub
		return detailsRepo.findByPhone(phone);
	}

	

	
	

}
