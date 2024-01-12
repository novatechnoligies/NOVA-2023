package com.nova.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.nova.dataservice.entity.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long>{

//	Object save(MultipartFile file, Long patientId, Long labId, Long technicianId);

}
