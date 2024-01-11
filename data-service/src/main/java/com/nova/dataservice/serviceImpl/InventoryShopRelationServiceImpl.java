package com.nova.dataservice.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nova.dataservice.entity.InventoryShopRelation;
import com.nova.dataservice.repository.InventoryShopRelationRepository;
import com.nova.dataservice.service.InventoryShopRelationService;
@Service

public class InventoryShopRelationServiceImpl implements InventoryShopRelationService {
	

	@Autowired
	InventoryShopRelationRepository relationRepository;
	
	
	
	@Override
	public InventoryShopRelation saveInventoryShopRelationController(InventoryShopRelation inventoryShopRelation) {
		return relationRepository.save(inventoryShopRelation);
	}

	public InventoryShopRelation uploadCSV(MultipartFile file) {
		// TODO Auto-generated method stub
		return relationRepository.uploadCSV(file);
		
	}


	
	
}
