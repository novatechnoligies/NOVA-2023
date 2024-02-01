package com.nova.dataservice.repository;


import java.time.LocalDate;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.nova.dataservice.entity.LabReportLocatiosn;

@Repository
public interface LabReportLocationReporitory extends JpaRepository<LabReportLocatiosn, Long>{

	List<LabReportLocatiosn> findAllReportsByPatientIdAndLabIdAndCreatedAt(Long patientId, Long labId,
			LocalDate createdAt);

	List<LabReportLocatiosn> findAllReportsByAppointmentId(Long appointmentId);
}
