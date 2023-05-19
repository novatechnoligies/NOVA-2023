package com.nova.dataservice.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.dataservice.entity.AppontmentDetails;
import com.nova.dataservice.repository.AppointmentDetailsRepository;
import com.nova.dataservice.service.AppointmentDetailservice;

@Service
public class AppointmentDetailsserviceimpl implements AppointmentDetailservice{

	@Autowired
	AppointmentDetailsRepository appRepo;
	
	@Override
	public AppontmentDetails saveAppointment(AppontmentDetails rl) {
		// TODO Auto-generated method stub
		return appRepo.save(rl);
	}

	@Override
	public List<AppontmentDetails> findAllAppointment() {
		// TODO Auto-generated method stub
		return appRepo.findAll();
	}

	@Override
	public Optional<AppontmentDetails> findAppointmentById(Long id) {
		// TODO Auto-generated method stub
		return appRepo.findById(id);
	}

}
