package com.nova.dataservice.dao;

import java.time.LocalDate;
import java.util.List;

import com.nova.dataservice.DTO.AppoinmenCounttDTO;
import com.nova.dataservice.DTO.AppoinmentDTO;

public interface AppointmentDao {

	List<AppoinmentDTO> findTodaysAppoinmentsById(LocalDate date, Long labId, LocalDate fromDate, LocalDate toDate);

	List<AppoinmentDTO> findTotalsAppoinmentsById(Long labId, LocalDate fromDate, LocalDate toDate);

	AppoinmenCounttDTO findTotalsAppoinmentsEarningsById(Long labId, LocalDate fromDate, LocalDate toDate);

	AppoinmenCounttDTO findTodayAppoinmentsEarningsById(Long labId, LocalDate fromDate, LocalDate toDate);

}
