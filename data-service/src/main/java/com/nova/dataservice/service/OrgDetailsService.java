package com.nova.dataservice.service;

import java.util.List;

import com.nova.dataservice.DTO.OrganizationDTO;
import com.nova.dataservice.entity.Locations;

import com.nova.dataservice.entity.Organization;

public interface OrgDetailsService {

	Organization saveOrgDetails(Organization details);


	List<Organization> getOrgListByOwnerId(Long ownerId);

	List<Organization> getAllOrgList();


	List<Organization> getAllOrgList();

	List<OrganizationDTO> searchOrgsByName(String orgName);


}
