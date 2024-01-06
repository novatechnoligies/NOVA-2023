package com.nova.dataservice.dao;

import java.util.List;

import com.nova.dataservice.DTO.AppoinmentDetailDTO;
import com.nova.dataservice.DTO.AppointmentTrackingDTO;

public interface AppointmentDetailDAO  {

	List<AppoinmentDetailDTO> findAllServicesByAppointmentIdAndPatientId(Long appId, Long patientId);

	List<AppointmentTrackingDTO> getCurrentAppointmentByAppointmentIdPatientIdAndLabId(Long appointmentId,
			Long patientId, Long labId);
	

}
