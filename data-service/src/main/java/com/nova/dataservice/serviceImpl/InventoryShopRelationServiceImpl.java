package com.nova.dataservice.serviceImpl;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nova.dataservice.entity.InventoryShopRelation;
import com.nova.dataservice.entity.MasterInventory;
import com.nova.dataservice.entity.ShopDetails;
import com.nova.dataservice.repository.InventoryShopRelationRepository;
import com.nova.dataservice.repository.ShopDetailsRepository;
import com.nova.dataservice.service.InventoryShopRelationService;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import jakarta.persistence.EntityNotFoundException;
@Service

public class InventoryShopRelationServiceImpl implements InventoryShopRelationService {
	

	@Autowired
	InventoryShopRelationRepository relationRepository;
	
	 @Autowired
	    private ShopDetailsRepository shopDetailsRepository; 
	
	
	
	@Override
	public InventoryShopRelation saveInventoryShopRelationController(InventoryShopRelation inventoryShopRelation) {
		return relationRepository.save(inventoryShopRelation);
	}

	public InventoryShopRelation uploadCSV(MultipartFile file) {
		// TODO Auto-generated method stub
		return null;
				//relationRepository.uploadCSV(file);
		
	}

	@Override
	public boolean uploadInventoryShopRelationByCsv(MultipartFile inventoryFile) {
		try (CSVReader reader = new CSVReader(new InputStreamReader(inventoryFile.getInputStream(), StandardCharsets.UTF_8))) {
	        List<String[]> csvData = reader.readAll();

	        // Assuming the first row is the header
	        String[] headers = csvData.get(0);

	        // Process data skipping the header
	        for (int i = 1; i < csvData.size(); i++) {
	            String[] row = csvData.get(i);
	            InventoryShopRelation inventoryShopRelation = mapRowToInventoryShopRelation(headers, row);
	            System.out.println(inventoryShopRelation);
	            relationRepository.save(inventoryShopRelation);
	        }
	        return true;

	    } catch (IOException | CsvException e) {
	        e.printStackTrace();
	    }
	    return false;
	}

	

	private InventoryShopRelation mapRowToInventoryShopRelation(String[] headers, String[] row) {
		InventoryShopRelation inventoryShopRelation = new InventoryShopRelation();
		//inventoryShopRelation.setId(Long.valueOf(row[0]));;
		inventoryShopRelation.setCreatedAt(LocalDate.now());
		inventoryShopRelation.setQuantity(Long.valueOf(row[2]));
		inventoryShopRelation.setStatus(Boolean.valueOf(row[3]));
		inventoryShopRelation.setUnit(Long.valueOf(row[4]));

		ShopDetails shopDetails = new ShopDetails();
		shopDetails.setId(Long.valueOf(row[6]));
		inventoryShopRelation.setShopDetails(shopDetails);
		
		MasterInventory inventory = new MasterInventory();
		inventory.setId(Long.valueOf(row[5]));
		inventoryShopRelation.setInventory(inventory);
		

//		ShopDetails shopDetails = shopDetailsRepository.findById(shopDetailsId)
//	            .orElseThrow(() -> new EntityNotFoundException("ShopDetails not found with ID: " + shopDetailsId));
//		inventoryShopRelation.setShopDetails(shopDetails);
//		Long shopDetailsId = Long.valueOf(row[5]);
		
		return inventoryShopRelation;
	}
	
}
