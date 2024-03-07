package com.nova.dataservice.service;

import java.util.List;
import java.util.Optional;

import com.nova.dataservice.DTO.OrganizationDTO;

import com.nova.dataservice.entity.Organization;

public interface OrgDetailsService {

	Organization saveOrgDetails(Organization details);

	List<Organization> getAllOrgList();

	List<OrganizationDTO> searchOrgsByName(String orgName);

	Optional<Organization> getOrgDetailsByAdminId(Long adminId);


}
