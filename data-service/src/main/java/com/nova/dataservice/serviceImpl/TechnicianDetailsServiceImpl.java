package com.nova.dataservice.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.dataservice.entity.TechnicianDetails;
import com.nova.dataservice.repository.TechnicianDetailsRepository;
import com.nova.dataservice.service.TechnicianDetailsService;

@Service
public class TechnicianDetailsServiceImpl implements TechnicianDetailsService {
	
	@Autowired
	TechnicianDetailsRepository techRepo;

	@Override
	public TechnicianDetails saveTechnicianDetails(TechnicianDetails technician) {
		// TODO Auto-generated method stub
		return techRepo.save(technician);
	}

}
