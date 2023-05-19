package com.nova.dataservice.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.dataservice.entity.ServiceMaster;
import com.nova.dataservice.repository.ServiceMasterRepository;
import com.nova.dataservice.service.ServiceMasterService;

@Service
public class ServiceMasterServiceImpl implements ServiceMasterService{
	
	@Autowired
	ServiceMasterRepository serviceMasterRepository;

	@Override
	public ServiceMaster saveServiceMaster(ServiceMaster serviceMaster) {
		// TODO Auto-generated method stub
		return serviceMasterRepository.save(serviceMaster);
	}

	@Override
	public List<ServiceMaster> findAllMaster() {
		// TODO Auto-generated method stub
		return serviceMasterRepository.findAll();
	}

	@Override
	public Optional<ServiceMaster> getMasterById(Long id) {
		// TODO Auto-generated method stub
		return serviceMasterRepository.findById(id);
	}

}
