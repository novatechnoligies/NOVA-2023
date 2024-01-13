package com.nova.dataservice.service;

import org.springframework.web.multipart.MultipartFile;

import com.nova.dataservice.entity.InventoryShopRelation;

public interface InventoryShopRelationService {

	InventoryShopRelation saveInventoryShopRelationController(InventoryShopRelation inventoryShopRelation);

	InventoryShopRelation uploadCSV(MultipartFile file);

	boolean uploadInventoryShopRelationByCsv(MultipartFile inventoryFile);

	

	

}
