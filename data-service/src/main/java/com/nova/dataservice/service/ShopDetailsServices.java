package com.nova.dataservice.service;

import java.util.List;
import java.util.Optional;

import com.nova.dataservice.entity.ShopDetails;

public interface ShopDetailsServices {

	ShopDetails saveShopDetails(ShopDetails details);

	List<ShopDetails> findAllShopDetails();

	Optional<ShopDetails> getById(Long id);

}
