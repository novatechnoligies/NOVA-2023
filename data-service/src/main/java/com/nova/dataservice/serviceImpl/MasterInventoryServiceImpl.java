package com.nova.dataservice.serviceImpl;


import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nova.dataservice.entity.MasterInventory;
import com.nova.dataservice.repository.MasterInventoryRepository;
import com.nova.dataservice.service.MasterInventoryService;
import org.springframework.web.multipart.MultipartFile;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
@Service

public class MasterInventoryServiceImpl implements MasterInventoryService {
	 
	@Autowired
	MasterInventoryRepository inventoryRepository;

	@Override
	public MasterInventory saveMasterInventory(MasterInventory inventory) {
		return inventoryRepository.save(inventory);
	}

	@Override
	public boolean uploadMasterInventoryByCsv(MultipartFile inventoryFile) {
	    try (CSVReader reader = new CSVReader(new InputStreamReader(inventoryFile.getInputStream(), StandardCharsets.UTF_8))) {
	        List<String[]> csvData = reader.readAll();

	        // Assuming the first row is the header
	        String[] headers = csvData.get(1);

	        // Process data skipping the header
	        for (int i = 1; i < csvData.size(); i++) {
	            String[] row = csvData.get(i);
	            MasterInventory masterInventory = mapRowToMasterInv(headers, row);
	            System.out.println(masterInventory);
	            inventoryRepository.save(masterInventory);
	        }
	        return true;
	        
	    } catch (IOException | CsvException e) {
	        e.printStackTrace();
	    }
	    return false;
	}

	private MasterInventory mapRowToMasterInv(String[] headers, String[] row) {
		// TODO Auto-generated method stub
		MasterInventory inventory = new MasterInventory();
		//inventory.setId(Long.valueOf(row[0]));
		inventory.setName(String.valueOf(row[2]));
		inventory.setAmount(Float.valueOf(row[1]));
		inventory.setStatus(Boolean.valueOf(row[3]));
		inventory.setType(String.valueOf(row[4]));
		return inventory;
	}
}

