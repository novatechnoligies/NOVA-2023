package com.nova.demo.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.nova.demo.DTO.AppShopConsumerOwnerDetails;
import com.nova.demo.DTO.AppointmentCountDetails;
import com.nova.demo.DTO.ShopDetailsDTO;
import com.nova.demo.entity.ShopDetails;

public interface AppShopConsumerOwnerDetailsDao {

	public List<AppShopConsumerOwnerDetails> getAllAppoinmentByShopIdAndDate(Long shopId, LocalDate date);

	public AppointmentCountDetails getTotalAppointmentCount(Long shopId, String appoinmentStatus,
			LocalDate fromDate, LocalDate toDate);

	public List<ShopDetailsDTO> getShopDetailsByShopTypeID(Long shopTypeID);

	public ShopDetailsDTO getShopDetailsAndAppointmentCountsAndOwnerDetailsByShopId(Long shopId, LocalDate fromDate,
			LocalDate toDate);
}
