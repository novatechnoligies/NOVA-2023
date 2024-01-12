package com.nova.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.nova.dataservice.entity.LabReportLocatiosn;

@Repository
public interface LabReportLocationReporitory extends JpaRepository<LabReportLocatiosn, Long>{


}
