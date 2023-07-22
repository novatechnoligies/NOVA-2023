package com.nova.dataservice.service;

import java.util.List;
import java.util.Optional;

import com.nova.dataservice.entity.MasterParameterSubParameter;

public interface MasterParameterSubParameterService {

	MasterParameterSubParameter saveMasterParameterSubParameter(MasterParameterSubParameter masterParameterSubParameter);

	List<MasterParameterSubParameter> getAllMasterParameterSubParameter();

	Optional<MasterParameterSubParameter> getMasterParameterSubParameterById(Long id);

}
