package com.nova.Owner.ServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.Owner.Entity.UserDetails;
import com.nova.Owner.Repo.OwnerOREmployeeRepo;
import com.nova.Owner.Service.OwnerOREmployeeService;

@Service
public class OwnerOREmployeeServiceImpl  implements OwnerOREmployeeService{
	@Autowired
	OwnerOREmployeeRepo employeeRepo;

	@Override
	public UserDetails createOwnerOREmployee(UserDetails details) {
		// TODO Auto-generated method stub
		return employeeRepo.save(details);
	}

	@Override
	public Optional<UserDetails> findOwnerByUserNameAndPassword(String userName, String password) {
		// TODO Auto-generated method stub
		return employeeRepo.findByUserNameAndPassword(userName,password);
	}

	@Override
	public Optional<UserDetails> findOwnerByPhoneNumber(String ownerPhone) {
		// TODO Auto-generated method stub
		return employeeRepo.findByPhone(ownerPhone);
	}

	@Override
	public Optional<UserDetails> findOwnerByEmail(String email) {
		// TODO Auto-generated method stub
		return employeeRepo.findByEmail(email);
	}

	
}
