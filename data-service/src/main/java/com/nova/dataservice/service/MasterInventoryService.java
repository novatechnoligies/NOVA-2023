package com.nova.dataservice.service;

import org.springframework.web.multipart.MultipartFile;

import com.nova.dataservice.entity.MasterInventory;

public interface MasterInventoryService {

	MasterInventory saveMasterInventory(MasterInventory inventory);

	boolean uploadMasterInventoryByCsv(MultipartFile inventoryFile);

}
