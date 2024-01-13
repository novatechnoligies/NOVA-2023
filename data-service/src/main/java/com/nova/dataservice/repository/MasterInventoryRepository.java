package com.nova.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.nova.dataservice.entity.MasterInventory;

@Repository

public interface MasterInventoryRepository extends JpaRepository<MasterInventory, Long> {

//	static MasterInventory uploadCSV(MultipartFile file) {
//		// TODO Auto-generated method stub
//		return null;
//	}


}
