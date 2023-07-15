package com.nova.Owner.Dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.nova.Owner.DTO.AppointmentCountByShopIdDTO;
import com.nova.Owner.DTO.TodayAppointmentCountDTO;

public interface AppointmentCountByShopIdDAO {

	AppointmentCountByShopIdDTO AppointmentCountByShopId(Long appointmentCountByShopId);

	TodayAppointmentCountDTO todayAppointmentCountForShop(Long shopid, LocalDate todayDate);

	TodayAppointmentCountDTO getAppointmentCountForShopBetweenTwoDates(Long shopId, LocalDate fromDate,
			LocalDate toDate);

}
