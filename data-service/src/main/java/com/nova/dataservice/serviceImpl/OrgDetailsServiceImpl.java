package com.nova.dataservice.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.dataservice.DTO.OrganizationDTO;
import com.nova.dataservice.DTO.UserDetailsDTO;
import com.nova.dataservice.entity.Organization;
import com.nova.dataservice.repository.OrgDetailsRepository;
import com.nova.dataservice.service.OrgDetailsService;

@Service
public class OrgDetailsServiceImpl implements OrgDetailsService{

	@Autowired
	OrgDetailsRepository orgDetailsRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	
	@Override
	public Organization saveOrgDetails(Organization details) {
		details.setCreatedAt(LocalDate.now());
		details.setStatus(true);
		details.setIsDeleted(false);
		return orgDetailsRepository.save(details);
	}


	@Override
	public List<OrganizationDTO> searchOrgsByName(String orgName) {
		List<Organization> orgDetailsList = orgDetailsRepository.findByName(orgName);
		List<OrganizationDTO> orgDetailsDTOList = orgDetailsList.stream()
		        .map(orgDetails -> modelMapper.map(orgDetails, OrganizationDTO.class))
		        .collect(Collectors.toList());
		return orgDetailsDTOList;
	}

}
