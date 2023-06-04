package com.nova.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nova.demo.entity.UserDetails;

@Repository
public interface UserDetailsRepo extends JpaRepository<UserDetails, Long>{

	Optional<UserDetails> findByUserNameAndPassword(String userName, String password);

	Optional<UserDetails> findByEmail(String email);

	Optional<UserDetails> findByPhone(String phone);

	Optional<UserDetails> findUserByPhoneAndOtp(String phone, String otp);

	Optional<UserDetails> findUserByEmailAndOtp(String email, String otp);
}
