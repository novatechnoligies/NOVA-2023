package com.nova.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nova.dataservice.entity.ShopAvalibility;


@Repository
public interface ShopsAvilabilityRepository extends JpaRepository<ShopAvalibility, Long> {

}
