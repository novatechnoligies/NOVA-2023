package com.nova.dataservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nova.dataservice.entity.UserDetails;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {

	@Query(nativeQuery = true, value ="Select * from user_details as c where c.first_name like %:ownerName%")
	List<UserDetails> findByFirstName(@Param("ownerName")String ownerName);

}
