package com.nova.dataservice.serviceImpl;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nova.dataservice.DTO.AppoinmentDetailDTO;
import com.nova.dataservice.entity.LabReportLocatiosn;
import com.nova.dataservice.repository.LabReportLocationReporitory;
import com.nova.dataservice.service.LabReportLocationService;

@Service
public class LabReportLocationServiceImpl implements LabReportLocationService{
	
	@Autowired
	LabReportLocationReporitory labReportLocationReporitory;

	@Override
	public void uploadLabReportLocation(MultipartFile file, Long patientId, Long labId, Long technicianId,
			Long appointmentId) {
		
		LabReportLocatiosn labReportLocatiosn = new LabReportLocatiosn();
		labReportLocatiosn.setFileName(file.getOriginalFilename());
		labReportLocatiosn.setAppointmentId(appointmentId);
		labReportLocatiosn.setPatientId(patientId);
		labReportLocatiosn.setLabId(labId);
		
		labReportLocationReporitory.save(labReportLocatiosn);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<LabReportLocatiosn> getAllReportsByPatientIdAndLabIdAndCreatedAt(Long patientId, Long labId,
			LocalDate createdAt) {
		return labReportLocationReporitory.findAllReportsByPatientIdAndLabIdAndCreatedAt(patientId,labId,createdAt);
	}

	

}
