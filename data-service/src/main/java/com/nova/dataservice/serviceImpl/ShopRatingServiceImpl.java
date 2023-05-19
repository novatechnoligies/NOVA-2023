package com.nova.dataservice.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.dataservice.entity.ShopRating;
import com.nova.dataservice.repository.ShopRatingRepository;
import com.nova.dataservice.service.ShopRatingService;

@Service
public class ShopRatingServiceImpl implements ShopRatingService{
	
	@Autowired
	ShopRatingRepository ratingRepository;

	@Override
	public ShopRating saveRating(ShopRating shopRating) {
		
		return ratingRepository.save(shopRating);
	}

}
