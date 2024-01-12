package com.nova.dataservice.service;

import java.util.List;

import com.nova.dataservice.entity.TechnicianDetails;

public interface TechnicianDetailsService {

	TechnicianDetails saveTechnicianDetails(TechnicianDetails technician);

	TechnicianDetails getTechnicianNotesByPatientIdAndTechnicianId(Long patientId, Long technicianId);

	List<TechnicianDetails> getAllTechnicianNotesByAppointmentIdAndTechnicianId(Long appointmentId, Long technicianId);

}
