package com.nova.Owner.Service;

import java.util.Optional;

import com.nova.Owner.Entity.UserDetails;

public interface OwnerOREmployeeService {

	UserDetails createOwnerOREmployee(UserDetails details);

	Optional<UserDetails> findOwnerByUserNameAndPassword(String userName, String password);

	Optional<UserDetails> findOwnerByPhoneNumber(String ownerPhone);

	Optional<UserDetails> findOwnerByEmail(String email);

}
