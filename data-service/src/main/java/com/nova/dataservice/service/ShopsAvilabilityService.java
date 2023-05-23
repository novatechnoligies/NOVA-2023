package com.nova.dataservice.service;

import java.util.List;
import java.util.Optional;

import com.nova.dataservice.entity.ShopAvalibility;

public interface ShopsAvilabilityService {

	ShopAvalibility saveShopAvailability(ShopAvalibility avalibility);

	List<ShopAvalibility> findAllShopAvailability();

	Optional<ShopAvalibility> getShopAvaibilityById(Long id);

}
