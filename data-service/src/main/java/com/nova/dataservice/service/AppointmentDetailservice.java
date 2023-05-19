package com.nova.dataservice.service;

import java.util.List;
import java.util.Optional;

import com.nova.dataservice.entity.AppontmentDetails;

public interface AppointmentDetailservice {

	AppontmentDetails saveAppointment(AppontmentDetails rl);

	List<AppontmentDetails> findAllAppointment();

	Optional<AppontmentDetails> findAppointmentById(Long id);

}
