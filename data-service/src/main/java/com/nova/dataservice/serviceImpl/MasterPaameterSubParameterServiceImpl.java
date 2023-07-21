package com.nova.dataservice.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.dataservice.entity.MasterParameterSubParameter;
import com.nova.dataservice.repository.MasterParameterSubParameterRepository;
import com.nova.dataservice.repository.ServiceMasterParameterRepo;
import com.nova.dataservice.service.MasterParameterSubParameterService;

@Service
public class MasterPaameterSubParameterServiceImpl implements MasterParameterSubParameterService{

	@Autowired
	MasterParameterSubParameterRepository masterParameterSubParameterRepository;
	
	@Override
	public MasterParameterSubParameter saveMasterParameterSubParameter(
			MasterParameterSubParameter masterParameterSubParameter) {
		// TODO Auto-generated method stub
		return masterParameterSubParameterRepository.save(masterParameterSubParameter);
	}

	@Override
	public List<MasterParameterSubParameter> getAllMasterParameterSubParameter() {
		// TODO Auto-generated method stub
		return masterParameterSubParameterRepository.findAll();
	}

	@Override
	public Optional<MasterParameterSubParameter> getMasterParameterSubParameterById(Long id) {
		// TODO Auto-generated method stub
		return masterParameterSubParameterRepository.findById(id);
	}

}
