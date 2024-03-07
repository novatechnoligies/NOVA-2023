package com.nova.dataservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nova.dataservice.entity.Organization;

public interface OrgDetailsRepository extends JpaRepository<Organization, Long>{
	

	@Query(nativeQuery = true, value ="SELECT * FROM organization_details  as od where od.org_name like %:orgName%")
	List<Organization> findByName(@Param("orgName")String orgName);

	List<Organization> getOrgDetailsByAdminId(Long adminId);

	
	
}
