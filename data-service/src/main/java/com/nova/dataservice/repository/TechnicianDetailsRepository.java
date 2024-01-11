package com.nova.dataservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nova.dataservice.entity.TechnicianDetails;

@Repository
public interface TechnicianDetailsRepository extends JpaRepository<TechnicianDetails, Long>  {

	TechnicianDetails findTechnicianNotesByPatientIdAndTechnicianId(Long patientId, Long technicianId);

//	TechnicianDetails findAllTechnicianNotesByPatientIdAndTechnicianId(Long appointmentId, Long technicianId);

	List<TechnicianDetails> findAllByPatientIdAndTechnicianId(Long appointmentId, Long technicianId);

}
