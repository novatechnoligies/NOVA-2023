package com.nova.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.nova.dataservice.entity.InventoryShopRelation;

@Repository

public interface InventoryShopRelationRepository extends JpaRepository<InventoryShopRelation, Long>{

//	InventoryShopRelation uploadCSV(MultipartFile file);

	
	

}
