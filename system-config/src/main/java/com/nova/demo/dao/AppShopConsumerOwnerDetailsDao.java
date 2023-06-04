package com.nova.demo.dao;

import java.time.LocalDate;
import java.util.List;

import com.nova.demo.DTO.AppShopConsumerOwnerDetails;

public interface AppShopConsumerOwnerDetailsDao {

	public List<AppShopConsumerOwnerDetails> getAllAppoinmentByShopIdAndDate(Long shopId, LocalDate date);
}
