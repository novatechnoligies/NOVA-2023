package com.nova.dataservice.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.modelmapper.internal.bytebuddy.asm.Advice.Local;

import com.nova.dataservice.DTO.AppoinmentDTO;
import com.nova.dataservice.entity.AppontmentDetails;

public interface AppointmentDetailservice {

	AppontmentDetails saveAppointment(AppontmentDetails rl);

	List<AppontmentDetails> findAllAppointment();

	Optional<AppontmentDetails> findAppointmentById(Long id);

	List<AppoinmentDTO> getTodaysAppointemtsByLabId(LocalDate date, Long labId, LocalDate fromDate, LocalDate toDate);

}
