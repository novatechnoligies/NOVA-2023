package com.nova.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nova.dataservice.entity.ServiceMasterShopRelation;

@Repository
public interface ShopServiceRelationRepository extends JpaRepository<ServiceMasterShopRelation, Long> {

}
