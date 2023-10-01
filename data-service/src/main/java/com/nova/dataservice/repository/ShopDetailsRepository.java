package com.nova.dataservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nova.dataservice.entity.ShopDetails;
import com.nova.dataservice.entity.ShopType;

@Repository
public interface ShopDetailsRepository extends JpaRepository<ShopDetails,Long> {
	
//	@Query("SELECT s FROM shop_details s WHERE s.shopType = :id AND s.shopName LIKE %:id%")
//     List<ShopDetails> searchLabDetailsByIdAndName(Long id);
	
	
	
//	@Query("SELECT s FROM shop_details s WHERE shop_type_id = :id AND shop_name LIKE %:name%")
//	List<ShopDetails> searchLabDetailsById(@Param("id") Long id, @Param("name") String name);
	
	@Query("SELECT s FROM ShopDetails s WHERE s.shopType = :id AND s.shopName LIKE %:namePattern%")
	List<ShopDetails> searchLabDetailsByIdAndName(@Param("id") ShopType id, @Param("namePattern") String namePattern);




}
