package com.nova.dataservice.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.dataservice.entity.MasterInventory;
import com.nova.dataservice.repository.MasterInventoryRepository;
import com.nova.dataservice.service.MasterInventoryService;
@Service

public class MasterInventoryServiceImpl implements MasterInventoryService {
	
	@Autowired
	MasterInventoryRepository inventoryRepository;

	@Override
	public MasterInventory saveMasterInventory(MasterInventory inventory) {
		return inventoryRepository.save(inventory);
	}

}
