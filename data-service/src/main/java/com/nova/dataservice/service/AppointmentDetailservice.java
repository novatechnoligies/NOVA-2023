package com.nova.dataservice.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.modelmapper.internal.bytebuddy.asm.Advice.Local;

import com.nova.dataservice.DTO.AppoinmenCounttDTO;
import com.nova.dataservice.DTO.AppoinmentDTO;
import com.nova.dataservice.DTO.AppoinmentDetailDTO;
import com.nova.dataservice.DTO.PatientDetailsDTO;
import com.nova.dataservice.entity.AppontmentDetails;

public interface AppointmentDetailservice {

	AppontmentDetails saveAppointment(AppontmentDetails rl);

	List<AppontmentDetails> findAllAppointment();

	Optional<AppontmentDetails> findAppointmentById(Long id);

	List<AppoinmentDTO> getTodaysAppointemtsByLabId(LocalDate date, Long labId, LocalDate fromDate, LocalDate toDate);
	
	AppoinmenCounttDTO getTotalAppointemtsCountByLabId(Long labId, LocalDate fromDate, LocalDate toDate);

	List<AppoinmentDetailDTO> getAllServicesByAppointmentIdAndPatientId(Long appointmentId, Long patientId);

	PatientDetailsDTO getPatientDetailsByAppointmentId(Long appointmentId);

	AppoinmenCounttDTO getTodaysAppointemtsCountByLabId(LocalDate date, Long labId, LocalDate fromDate,
			LocalDate toDate);

	AppoinmenCounttDTO getTodaysCompleatedReportCountByLabId(LocalDate date, Long labId, LocalDate fromDate,
			LocalDate toDate, String status);


	AppoinmenCounttDTO getTotalAppoinmentsEarningsByLabId(Long labId, LocalDate fromDate, LocalDate toDate);

	AppoinmenCounttDTO getTodayAppoinmentsEarningsByLabId(Long labId, LocalDate fromDate, LocalDate toDate);


	

}
