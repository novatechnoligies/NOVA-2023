package com.nova.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nova.dataservice.entity.ShopRating;
import com.nova.dataservice.service.ShopRatingService;

@Repository
public interface ShopRatingRepository extends JpaRepository<ShopRating, Long> {

}
