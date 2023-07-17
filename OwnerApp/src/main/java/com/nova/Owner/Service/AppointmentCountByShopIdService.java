package com.nova.Owner.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.nova.Owner.DTO.AppointmentCountByShopIdDTO;
import com.nova.Owner.DTO.ShopDetailsDTO;
import com.nova.Owner.DTO.TodayAppointmentCountDTO;

public interface AppointmentCountByShopIdService {

	AppointmentCountByShopIdDTO AppointmentCountByShopId(Long shopId);

	TodayAppointmentCountDTO todayAppointmentCount(Long shopid, LocalDate todayDate);

	TodayAppointmentCountDTO getAppointmentCountForShopBetweenTwoDates(Long shopId, LocalDate fromDate,
			LocalDate toDate);

	ShopDetailsDTO getLabCountByShopTypeId(Long shop_type_id);

}
