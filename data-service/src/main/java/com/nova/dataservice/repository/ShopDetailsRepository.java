package com.nova.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nova.dataservice.entity.ShopDetails;

@Repository
public interface ShopDetailsRepository extends JpaRepository<ShopDetails,Long> {

}
