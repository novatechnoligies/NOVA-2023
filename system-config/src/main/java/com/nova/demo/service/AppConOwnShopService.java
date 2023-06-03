package com.nova.demo.service;

import java.time.LocalDate;
import java.util.List;

import com.nova.demo.DTO.AppShopConsumerOwnerDetails;

public interface AppConOwnShopService {

	List<AppShopConsumerOwnerDetails> getAllAppoinmentByShopIdAndDate(Long shopId, LocalDate date);

}
