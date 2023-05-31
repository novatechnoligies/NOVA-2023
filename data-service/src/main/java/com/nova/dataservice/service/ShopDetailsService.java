package com.nova.dataservice.service;

import java.util.List;
import java.util.Optional;

import com.nova.dataservice.entity.ShopDetails;

public interface ShopDetailsService {

	ShopDetails saveShopDetails(ShopDetails details);

	List<ShopDetails> findAllShopDetails();

	Optional<ShopDetails> findByIdShopDetails(Long id);

}
