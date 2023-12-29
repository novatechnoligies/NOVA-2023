package com.nova.dataservice.dao;

import java.time.LocalDate;
import java.util.List;

import com.nova.dataservice.DTO.AppoinmentDTO;

public interface AppointmentDao {

	List<AppoinmentDTO> findTodaysAppoinmentsById(LocalDate date, Long labId, LocalDate fromDate, LocalDate toDate);

}
