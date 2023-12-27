package com.nova.dataservice.service;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.nova.dataservice.DTO.SlotAvailabilityDTO;
import com.nova.dataservice.entity.SlotAvailability;

public interface SlotAvailabilityServices {


	SlotAvailability saveSlotAvailability(SlotAvailability slotAvailability);

	List<SlotAvailability> getAllSlotAvailability();

	Optional<SlotAvailability> getSlotAvailabilityById(Long id);

	List<SlotAvailabilityDTO> getAllSlotAvailabilityByLabIdAndDate(LocalDate date, Long labId);



}
