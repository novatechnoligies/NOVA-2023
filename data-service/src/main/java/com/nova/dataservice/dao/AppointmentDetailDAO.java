package com.nova.dataservice.dao;

import java.time.LocalDate;
import java.util.List;

import com.nova.dataservice.DTO.AppoinmentDetailDTO;
import com.nova.dataservice.DTO.EachLabEariningByOwnerIdDTO;
import com.nova.dataservice.DTO.EarningDetailsDTO;

public interface AppointmentDetailDAO  {

	List<AppoinmentDetailDTO> findAllServicesByAppointmentIdAndPatientId(Long appId, Long patientId);

	List<AgeCategoryAppointmentCountDTO> getAdultAppointmentCountByLabId(Long labId);

	EarningDetailsDTO findEarningsByOwnerIdAndDate(Long ownerId, LocalDate fromDate, LocalDate toDate);

	List<AppoinmentDetailDTO> findPastAppointmentsByLabIdAndPatientId(Long labId, Long patientId);

	List<EachLabEariningByOwnerIdDTO> findEachLabEariningByOwnerId(Long ownerId);
	

}
