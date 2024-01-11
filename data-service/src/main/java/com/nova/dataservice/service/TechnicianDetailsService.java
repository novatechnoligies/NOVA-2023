package com.nova.dataservice.service;

import com.nova.dataservice.entity.TechnicianDetails;

public interface TechnicianDetailsService {

	TechnicianDetails saveTechnicianDetails(TechnicianDetails technician);

	TechnicianDetails getTechnicianNotesByPatientIdAndTechnicianId(Long patientId, Long technicianId);

}