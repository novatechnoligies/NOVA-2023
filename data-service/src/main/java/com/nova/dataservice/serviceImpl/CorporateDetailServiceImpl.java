package com.nova.dataservice.serviceImpl;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.nova.dataservice.entity.CorporateAppontmentDetails;
import com.nova.dataservice.entity.CorporateDetails;
import com.nova.dataservice.entity.Role;
import com.nova.dataservice.repository.CorporateAppointmentDetailsRepository;
import com.nova.dataservice.repository.CorporateDetailRepository;
import com.nova.dataservice.service.CorporateDetailService;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.List;

@Service

public class CorporateDetailServiceImpl implements CorporateDetailService {
	
	@Autowired
	CorporateDetailRepository corporateDetailRepository ;
	
	@Autowired
	CorporateAppointmentDetailsRepository appointmentDetailsRepository;
	
	@Autowired
	RestTemplate restTemplate;

	@Override
	public CorporateDetails saveCorporateDetails(CorporateDetails corporateDetails) {
		return  corporateDetailRepository.save(corporateDetails);
	}

	@Override
	public boolean uploadCorporateeUsersByCsv(MultipartFile file) {
		try (CSVReader reader = new CSVReader(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))) {
	        List<String[]> csvData = reader.readAll();
			 
	        String[] headers = csvData.get(0);
	         Long slotId = 1l;
	        for (int i = 1; i < csvData.size(); i++) {
	            String[] row = csvData.get(i);
	            CorporateDetails corporateDetails = mapCorporateUserByCSV(headers, row);
	            System.out.println(corporateDetails);
	            corporateDetails.setCreatedAt(LocalDate.now());
	            corporateDetails.setStatus(true);
	            corporateDetails.setIsDeleted(false);
	            corporateDetails = corporateDetailRepository.save(corporateDetails);
	            
	            CorporateAppontmentDetails appontmentDetails = new CorporateAppontmentDetails();
	            appontmentDetails.setAppointmentStatus("BOOKED");
	            appontmentDetails.setSlotId(slotId); 
	            appontmentDetails.setShopId(corporateDetails.getId());
	            appontmentDetails.setServiceId(corporateDetails.getId());
	            appontmentDetails.setAmount(73838f);
	            appontmentDetails.setTax1(64838f);
	            appontmentDetails.setTax2(6373637f);
	            appontmentDetails.setGst(63723838f);
	            appontmentDetails.setCgst(6734746f);
	            appontmentDetails.setSgst(6434646f);
	            appontmentDetails.setCreatedAt(LocalDate.now());
	            appontmentDetails.setStatus(Boolean.valueOf(true));
	            appontmentDetails.setReferedByNovaUserName(String.valueOf(""));
	            appontmentDetails.setReferedByNonNovaUserName(String.valueOf(""));
	            
	            appontmentDetails.setPatientId(corporateDetails.getId());
	            
	           CorporateAppontmentDetails data = appointmentDetailsRepository.save(appontmentDetails);
	            
	            if (data !=null) {
	    			
	    			restTemplate.getForObject("http://localhost:8083/mailservice/sendAppointDetails?tomail="+corporateDetails.getEmail()+"&slotId="+slotId+"&date="+"2024-12-12", Object.class);
	    			slotId++;
	    		} 
	            
	            
	        }
	        return true;

	    } catch (IOException | CsvException e) {
	        e.printStackTrace();
	    }
	    return false;
	}

	private CorporateDetails mapCorporateUserByCSV(String[] headers, String[] row) {
		CorporateDetails corporateDetails = new CorporateDetails();
		corporateDetails.setEmployeeId(String.valueOf(row[0]));
		corporateDetails.setCompanyName(String.valueOf(row[1]));
		corporateDetails.setcompanyCode(String.valueOf(row[2]));
		corporateDetails.setFirstName(String.valueOf(row[3]));
		corporateDetails.setLastName(String.valueOf(row[4]));
		corporateDetails.setEmail(String.valueOf(row[5]));
		corporateDetails.setEmployeeEmail(String.valueOf(row[6]));
		corporateDetails.setPhone(String.valueOf(row[7]));
		corporateDetails.setemployeePhone(String.valueOf(row[8]));
		corporateDetails.setPin(String.valueOf(row[9]));
		corporateDetails.setGender(String.valueOf(row[10]));
		corporateDetails.setUsername(String.valueOf(row[11]));
		corporateDetails.setPassword(String.valueOf(row[12]));
		corporateDetails.setAdharNo(String.valueOf(row[13]));
		corporateDetails.setAdharPhoto(String.valueOf(row[14]));
		corporateDetails.setOwnerPhoto(String.valueOf(row[15]));
		corporateDetails.setDob(LocalDate.now());
		corporateDetails.setAge(Integer.valueOf(row[17]));
		
		Role role=new Role();
		role.setId(4l);
		corporateDetails.setRole(role);
		
		return corporateDetails;
	}

}
