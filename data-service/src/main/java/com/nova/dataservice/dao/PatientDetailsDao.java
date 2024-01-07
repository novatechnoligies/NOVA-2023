package com.nova.dataservice.dao;

import com.nova.dataservice.DTO.PatientDetailsDTO;

public interface PatientDetailsDao {

	PatientDetailsDTO findPatientDetailsByAppointmentId(Long appointmentId);

}
