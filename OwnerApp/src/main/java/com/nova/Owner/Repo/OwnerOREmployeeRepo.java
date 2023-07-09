package com.nova.Owner.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.nova.Owner.Entity.UserDetails;

public interface OwnerOREmployeeRepo extends JpaRepository<UserDetails, Long>{

	Optional<UserDetails> findByUserNameAndPassword(String userName, String password);

	Optional<UserDetails> findByPhone(String ownerPhone);

	Optional<UserDetails> findByEmail(String email);

	

}
