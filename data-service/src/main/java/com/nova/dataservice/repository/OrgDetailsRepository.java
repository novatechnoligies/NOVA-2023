package com.nova.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nova.dataservice.entity.Organization;

public interface OrgDetailsRepository extends JpaRepository<Organization, Long>{

	
}
