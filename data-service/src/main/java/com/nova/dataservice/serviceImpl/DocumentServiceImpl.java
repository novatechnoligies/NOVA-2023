package com.nova.dataservice.serviceImpl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nova.dataservice.entity.Document;
import com.nova.dataservice.repository.DocumentRepository;
import com.nova.dataservice.service.DocumentService;

@Service
public class DocumentServiceImpl<Make> implements DocumentService{
	
	@Autowired
	DocumentRepository docRepo;

	public void saveDocument(MultipartFile file, Long patientId, Long labId, Long technicianId) {
        Document document = new Document();
        document.setFileName(file.getOriginalFilename());
        try {
			document.setFileData(file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        document.setPatientId(patientId);
        document.setLabId(labId);
        document.setTechnicianId(technicianId);

        docRepo.save(document);
   }

}
