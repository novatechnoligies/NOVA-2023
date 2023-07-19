package com.nova.dataservice.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.dataservice.entity.ServiceMasterParameter;
import com.nova.dataservice.repository.ServiceMasterParameterRepo;
import com.nova.dataservice.service.ServiceMasterParameterService;
import com.nova.dataservice.service.ServiceMasterService;

@Service

public class ServiceMasterParameterServiceImpl implements ServiceMasterParameterService {
	
	@Autowired
	ServiceMasterParameterRepo masterParameterRepo;

	@Override
	public ServiceMasterParameter serviceMasterParameter(ServiceMasterParameter masterParameter) {
		// TODO Auto-generated method stub
		return masterParameterRepo.save(masterParameter);
	}

}
