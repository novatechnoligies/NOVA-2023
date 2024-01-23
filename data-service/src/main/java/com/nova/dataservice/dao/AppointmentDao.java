package com.nova.dataservice.dao;

import java.time.LocalDate;
import java.util.List;

import com.nova.dataservice.DTO.AppoinmenCounttDTO;
import com.nova.dataservice.DTO.AppoinmentDTO;

public interface AppointmentDao {

	List<AppoinmentDTO> findTodaysAppoinmentsById(LocalDate date, Long labId, LocalDate fromDate, LocalDate toDate);

	AppoinmenCounttDTO findTotalsAppoinmentsById(Long labId, LocalDate fromDate, LocalDate toDate);

	AppoinmenCounttDTO findTodaysAppoinmentsCountByLabId(LocalDate date, Long labId, LocalDate fromDate, LocalDate toDate);

	AppoinmenCounttDTO findTotalAppoinmentsEarningsByLabId(Long labId, LocalDate fromDate, LocalDate toDate);

	AppoinmenCounttDTO findCompleatedReportByLabId(LocalDate date, Long labId, LocalDate fromDate, LocalDate toDate,String status);

	AppoinmenCounttDTO findTotalAppointemtsCountByLabId(Long labId, LocalDate fromDate, LocalDate toDate);

	AppoinmenCounttDTO findTodayAppoinmentsEarningsByLabId(Long labId, LocalDate fromDate, LocalDate toDate);




		

}
 