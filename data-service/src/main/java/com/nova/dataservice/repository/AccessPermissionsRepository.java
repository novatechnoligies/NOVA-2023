package com.nova.dataservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nova.dataservice.entity.AccessPermissions;
import com.nova.dataservice.entity.UserDetails;

@Repository
public interface AccessPermissionsRepository extends JpaRepository<AccessPermissions, Long>{

	List<AccessPermissions> findByEmployeeDetails(UserDetails userDetails);

}
