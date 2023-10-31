package com.nova.dataservice.service;

import java.util.List;

import com.nova.dataservice.entity.Organization;

public interface OrgDetailsService {

	Organization saveOrgDetails(Organization details);

	List<Organization> getOrgListByOwnerId(Long ownerId);

	List<Organization> getAllOrgList();


}
