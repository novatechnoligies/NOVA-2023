package com.nova.dataservice.service;

import org.springframework.web.multipart.MultipartFile;

import com.nova.dataservice.entity.CorporateDetails;

public interface CorporateDetailService {

	CorporateDetails saveCorporateDetails(CorporateDetails corporateDetails);

	boolean uploadCorporateeUsersByCsv(MultipartFile file);

}
