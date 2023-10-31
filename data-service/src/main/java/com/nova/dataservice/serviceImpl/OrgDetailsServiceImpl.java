package com.nova.dataservice.serviceImpl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.dataservice.entity.Organization;
import com.nova.dataservice.repository.OrgDetailsRepository;
import com.nova.dataservice.service.OrgDetailsService;

@Service
public class OrgDetailsServiceImpl implements OrgDetailsService{

	@Autowired
	OrgDetailsRepository orgDetailsRepository;
	
	@Override
	public Organization saveOrgDetails(Organization details) {
		details.setCreatedAt(LocalDate.now());
		details.setStatus(true);
		details.setIsDeleted(false);
		return orgDetailsRepository.save(details);
	}

}
