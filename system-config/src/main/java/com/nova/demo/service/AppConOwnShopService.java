package com.nova.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.nova.demo.DTO.AppShopConsumerOwnerDetails;
import com.nova.demo.DTO.AppointmentCountDetails;
import com.nova.demo.DTO.ShopDetailsDTO;
import com.nova.demo.entity.ShopDetails;

public interface AppConOwnShopService {

	List<AppShopConsumerOwnerDetails> getAllAppoinmentByShopIdAndDate(Long shopId, LocalDate date);

	AppointmentCountDetails getTotalAppointmentCount(Long shopId, String appoinmentStatus, LocalDate fromDate,
			LocalDate toDate);

	List<ShopDetailsDTO> getShopDetailsByShopTypeID(Long shopTypeID);

	ShopDetailsDTO getShopDetailsAndAppointmentCountsAndOwnerDetailsByShopId(Long shopId, LocalDate fromDate,
			LocalDate toDate);

}
