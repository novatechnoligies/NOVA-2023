package com.nova.dataservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nova.dataservice.entity.ServiceMasterShopRelation;

@Repository
public interface ShopServiceRelationRepository extends JpaRepository<ServiceMasterShopRelation, Long> {

//	@Query(nativeQuery = true, value = "SELECT ssr.id AS id FROM nova_v1_4.shop_service_relation as ssr " +
//	        "JOIN service_master as sm ON sm.id = ssr.service_id " +
//	        "WHERE ssr.shop_id = :labId AND sm.name LIKE %:service%")
//	List<ServiceMasterShopRelation> findAllShopServiceByLab(@Param("labId") Long labId, @Param("service") String service);


}
