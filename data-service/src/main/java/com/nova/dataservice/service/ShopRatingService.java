package com.nova.dataservice.service;

import java.util.List;
import java.util.Optional;

import com.nova.dataservice.entity.ShopRating;

public interface ShopRatingService {

	ShopRating saveRating(ShopRating shopRating);

	List<ShopRating> findAllShopRataing();

	Optional<ShopRating> getShopRatingById(long id);



}
