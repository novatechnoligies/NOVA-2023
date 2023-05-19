package com.nova.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nova.dataservice.entity.ShopType;

@Repository
public interface ShopTypeRepository extends JpaRepository<ShopType, Long> {

}
