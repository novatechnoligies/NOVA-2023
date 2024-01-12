package com.nova.dataservice.service;


import org.springframework.web.multipart.MultipartFile;

public interface DocumentService   {

	void saveDocument(MultipartFile file, Long patientId, Long labId, Long technicianId);


}
