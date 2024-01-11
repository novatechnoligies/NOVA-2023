package com.nova.dataservice.serviceImpl;

import java.time.LocalDate;

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
		technician.setCreatedAt(LocalDate.now());
		return techRepo.save(technician);
	}

	@Override
	public TechnicianDetails getTechnicianNotesByPatientIdAndTechnicianId(Long patientId, Long technicianId) {
		return techRepo.findTechnicianNotesByPatientIdAndTechnicianId(patientId,technicianId);
	}

}
