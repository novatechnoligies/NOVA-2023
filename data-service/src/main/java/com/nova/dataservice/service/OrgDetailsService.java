package com.nova.dataservice.service;

import java.util.List;

import com.nova.dataservice.DTO.OrganizationDTO;
import com.nova.dataservice.entity.Organization;

public interface OrgDetailsService {

	Organization saveOrgDetails(Organization details);

	List<OrganizationDTO> searchOrgsByName(String orgName);

}
