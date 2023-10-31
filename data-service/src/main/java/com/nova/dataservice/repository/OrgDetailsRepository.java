package com.nova.dataservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nova.dataservice.entity.Organization;
import com.nova.dataservice.entity.UserDetails;

public interface OrgDetailsRepository extends JpaRepository<Organization, Long>{

	List<Organization> findByOwn(UserDetails ownerId);

	
}
