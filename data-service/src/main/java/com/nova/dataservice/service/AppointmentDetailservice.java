package com.nova.dataservice.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.modelmapper.internal.bytebuddy.asm.Advice.Local;

import com.nova.dataservice.DTO.AppoinmentDTO;
import com.nova.dataservice.DTO.AppoinmentDetailDTO;
import com.nova.dataservice.DTO.EarningDetailsDTO;
import com.nova.dataservice.DTO.PatientDetailsDTO;
import com.nova.dataservice.dao.AgeCategoryAppointmentCountDTO;
import com.nova.dataservice.entity.AppontmentDetails;

public interface AppointmentDetailservice {

	AppontmentDetails saveAppointment(AppontmentDetails rl);

	List<AppontmentDetails> findAllAppointment();

	Optional<AppontmentDetails> findAppointmentById(Long id);

	List<AppoinmentDTO> getTodaysAppointemtsByLabId(LocalDate date, Long labId, LocalDate fromDate, LocalDate toDate);

	List<AppoinmentDetailDTO> getAllServicesByAppointmentIdAndPatientId(Long appointmentId, Long patientId);

	PatientDetailsDTO getPatientDetailsByAppointmentId(Long appointmentId);

	List<AgeCategoryAppointmentCountDTO> getAdultAppointmentCountByLabId(Long labId);

	EarningDetailsDTO getEarningDetailsByOwnerIdAndDate(Long ownerId, LocalDate fromDate, LocalDate toDate);

	List<AppoinmentDetailDTO> getPastAppointmentsByLabIdAndPatientId(Long labId, Long patientId);

	



}
