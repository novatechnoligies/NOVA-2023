package com.nova.dataservice.serviceImpl;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.dataservice.entity.CorporateDetails;
import com.nova.dataservice.entity.Role;
import com.nova.dataservice.repository.CorporateDetailRepository;
import com.nova.dataservice.service.CorporateDetailService;

@Service

public class CorporateDetailServiceImpl implements CorporateDetailService {
	
	@Autowired
	CorporateDetailRepository corporateDetailRepository ;

	@Override
	public CorporateDetails saveCorporateDetails(CorporateDetails corporateDetails) {
		return  corporateDetailRepository.save(corporateDetails);
//		corporateDetails.setStatus(true);
//		corporateDetails.setIsDeleted(false);
//		corporateDetails.setCreatedAt(LocalDate.now());
//		corporateDetails.setIsPhoneNoVerified(false);
//		Optional<Role> role = corporateDetailRepository.findById(corporateDetails.getRole().getId());
//		if (role.isPresent()) {
//			corporateDetails.setRole(role.get());
//		}
//		return corporateDetailRepository.save(corporateDetails);
	}

}
