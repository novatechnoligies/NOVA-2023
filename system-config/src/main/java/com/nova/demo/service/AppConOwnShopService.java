package com.nova.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.nova.demo.DTO.AppShopConsumerOwnerDetails;
import com.nova.demo.DTO.AppointmentCountDetails;

public interface AppConOwnShopService {

	List<AppShopConsumerOwnerDetails> getAllAppoinmentByShopIdAndDate(Long shopId, LocalDate date);

	AppointmentCountDetails getTotalAppointmentCount(Long shopId, String appoinmentStatus, LocalDate fromDate,
			LocalDate toDate);

}
