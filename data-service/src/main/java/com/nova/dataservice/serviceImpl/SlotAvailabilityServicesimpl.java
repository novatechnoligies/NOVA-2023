package com.nova.dataservice.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.dataservice.entity.SlotAvailability;
import com.nova.dataservice.repository.SlotAvailabilityRepository;
import com.nova.dataservice.service.SlotAvailabilityServices;

@Service
public class SlotAvailabilityServicesimpl implements SlotAvailabilityServices {

	@Autowired
	SlotAvailabilityRepository availabilityRepository;
	
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

}
