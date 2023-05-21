package com.nova.dataservice.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.dataservice.entity.SlotAvailability;
import com.nova.dataservice.repository.SlotAvailabilityRepository;
import com.nova.dataservice.service.SlotAvailabilityServices;

@Service
public class SlotAvailabilityServicesimpl implements SlotAvailabilityServices {

	@Autowired
	SlotAvailabilityRepository slotAvailabilityRepository;
	
	@Override
	public SlotAvailability save(SlotAvailability availability) {
		return slotAvailabilityRepository.save(availability);
	}

}
