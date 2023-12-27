package com.nova.dataservice.serviceImpl;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.dataservice.DTO.SlotAvailabilityDTO;
import com.nova.dataservice.dao.UserServiceDao;
import com.nova.dataservice.entity.SlotAvailability;
import com.nova.dataservice.repository.SlotAvailabilityRepository;
import com.nova.dataservice.service.SlotAvailabilityServices;

@Service
public class SlotAvailabilityServicesimpl implements SlotAvailabilityServices {

	@Autowired
	SlotAvailabilityRepository availabilityRepository;
	
	@Autowired
	UserServiceDao userServiceDao;
	
	@Override
	public SlotAvailability saveSlotAvailability(SlotAvailability slotAvailability) {
		// TODO Auto-generated method stub
		return availabilityRepository.save(slotAvailability);
	}

	@Override
	public List<SlotAvailability> getAllSlotAvailability() {
		// TODO Auto-generated method stub
		return availabilityRepository.findAll();
	}

	@Override
	public Optional<SlotAvailability> getSlotAvailabilityById(Long id) {
		// TODO Auto-generated method stub
		return availabilityRepository.findById(id);

	}

	@Override
	public List<SlotAvailabilityDTO> getAllSlotAvailabilityByLabIdAndDate(LocalDate date, Long labId) {
		return userServiceDao.getAllSlotAvailabilityByLabIdAndDate(date, labId);
	}

}
