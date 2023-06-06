package com.nova.demo.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.nova.demo.DTO.AppShopConsumerOwnerDetails;
import com.nova.demo.DTO.AppointmentCountDetails;

public interface AppShopConsumerOwnerDetailsDao {

	public List<AppShopConsumerOwnerDetails> getAllAppoinmentByShopIdAndDate(Long shopId, LocalDate date);

	public AppointmentCountDetails getTotalAppointmentCount(Long shopId, String appoinmentStatus,
			LocalDate fromDate, LocalDate toDate);
}
