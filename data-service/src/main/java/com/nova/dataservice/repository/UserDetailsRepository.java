package com.nova.dataservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import com.nova.dataservice.entity.UserDetails;

@EnableJpaRepositories
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {

	@Query(nativeQuery = true, value ="Select * from user_details as c where c.first_name like %:ownerName%")
	List<UserDetails> findByFirstName(@Param("ownerName")String ownerName);
	
	//@Query(nativeQuery = true, value ="Select * from user_details as c where c.username = :userName and c.password = :password")
	Optional<UserDetails> findByUsernameAndPassword(String userName, String password);

	Optional<UserDetails> findByEmail(String email);

	@Query(nativeQuery = true, value ="Select * from user_details as c where c.phone like :phone% and c.role_id = :roleId")
	List<UserDetails> findByPhoneAndRole(String phone,Long roleId);

	Optional<UserDetails> findUserByPhoneAndOtp(String phone, String otp);

	Optional<UserDetails> findUserByEmailAndOtp(String email, String otp);

	List<UserDetails> findByCreatedBy(Long userId);

	@Query(nativeQuery = true, value ="Select * from user_details as c where c.first_name like %:ownerName% and c.CreatedBy = :createdBy and c.status = :status")
	List<UserDetails> searchOwnerByNameAndCreatedByAndStatus(String ownerName, Long createdBy, Boolean status);

}
