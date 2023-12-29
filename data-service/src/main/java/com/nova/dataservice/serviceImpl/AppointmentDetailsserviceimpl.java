package com.nova.dataservice.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.dataservice.DTO.AppoinmentDTO;
import com.nova.dataservice.dao.AppointmentDao;
import com.nova.dataservice.entity.AppontmentDetails;
import com.nova.dataservice.entity.SlotAvailability;
import com.nova.dataservice.entity.UserDetails;
import com.nova.dataservice.repository.AppointmentDetailsRepository;
import com.nova.dataservice.repository.SlotAvailabilityRepository;
import com.nova.dataservice.service.AppointmentDetailservice;

@Service
public class AppointmentDetailsserviceimpl implements AppointmentDetailservice{

	@Autowired
	AppointmentDetailsRepository appRepo;
	
	@Autowired
	SlotAvailabilityRepository availabilityRepository;
	
	@Autowired
	AppointmentDao appointmentDao;
	
	@Override
	public AppontmentDetails saveAppointment(AppontmentDetails rl) {
		
		rl.setCreatedAt(LocalDate.now());
		rl.setStatus(true);
		rl.setAppointmentStatus("BOOKED");
		
		SlotAvailability slotAvailability = availabilityRepository.findById(rl.getSlotId()).get();
		slotAvailability.setAppintmentStatus("BOOKED");
		UserDetails details = new UserDetails();
		details.setId(rl.getId());
		rl.setId(null);
		slotAvailability.setUserDetails(details);
		availabilityRepository.save(slotAvailability);
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

	@Override
	public List<AppoinmentDTO> getTodaysAppointemtsByLabId(LocalDate date, Long labId ,LocalDate fromDate, LocalDate toDate) {
		return appointmentDao.findTodaysAppoinmentsById(date, labId, fromDate, toDate);
	}

}
