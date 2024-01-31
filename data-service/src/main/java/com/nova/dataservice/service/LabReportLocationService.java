package com.nova.dataservice.service;


import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.nova.dataservice.entity.LabReportLocatiosn;

public interface LabReportLocationService   {

	void uploadLabReportLocation(MultipartFile file, Long patientId, Long labId, Long technicianId, Long appointmentId);

	List<LabReportLocatiosn> getAllReportsByAppointmentI(Long appointmentId);



}
