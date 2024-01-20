package com.nova.dataservice.dao;

import java.util.List;

import com.nova.dataservice.DTO.AppoinmentDTO;
import com.nova.dataservice.DTO.AppoinmentDetailDTO;

public interface AppointmentDetailDAO  {

	List<AppoinmentDetailDTO> findAllServicesByAppointmentIdAndPatientId(Long appId, Long patientId);

	List<AppoinmentDetailDTO> findAllAppointmentsByLabId(Long labId);

	

}
