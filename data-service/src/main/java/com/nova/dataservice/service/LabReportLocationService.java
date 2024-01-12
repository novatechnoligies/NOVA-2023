package com.nova.dataservice.service;


import org.springframework.web.multipart.MultipartFile;

public interface LabReportLocationService   {

	void uploadLabReportLocation(MultipartFile file, Long patientId, Long labId, Long technicianId, Long appointmentId);



}
