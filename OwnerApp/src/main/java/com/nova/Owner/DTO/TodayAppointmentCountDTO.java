package com.nova.Owner.DTO;

import java.time.LocalDate;

public class TodayAppointmentCountDTO {
	
	private Long id;
	
	private Long todayAppointmentCount;

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTodayAppointmentCount() {
		return todayAppointmentCount;
	}

	public void setTodayAppointmentCount(Long todayAppointmentCount) {
		this.todayAppointmentCount = todayAppointmentCount;
	}

}
