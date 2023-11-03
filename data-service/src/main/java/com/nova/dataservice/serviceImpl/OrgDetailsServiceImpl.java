package com.nova.dataservice.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.dataservice.DTO.OrganizationDTO;
import com.nova.dataservice.DTO.UserDetailsDTO;
import com.nova.dataservice.entity.Locations;
import com.nova.dataservice.entity.Organization;
import com.nova.dataservice.entity.UserDetails;
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


	@Override
	public List<Organization> getOrgListByOwnerId(Long ownerId) {
		// TODO Auto-generated method stub
		UserDetails ud = new UserDetails();
		ud.setId(ownerId);
		return orgDetailsRepository.findByOwn(ud);
	}

	@Override
	public List<Organization> getAllOrgList() {
		// TODO Auto-generated method stub
		return orgDetailsRepository.findAll();
	}


	@Override
	public List<Organization> getAllOrgList() {
		// TODO Auto-generated method stub
		return orgDetailsRepository.findAll();
	}
	

}
