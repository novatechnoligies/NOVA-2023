package com.nova.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nova.dataservice.entity.ShopUpdateRequest;


@Repository
public interface ShopUpdateRequestRepo extends JpaRepository<ShopUpdateRequest, Long> {

}
