package com.nova.dataservice.service;

import java.util.List;
import java.util.Optional;

import com.nova.dataservice.DTO.ServiceMasterDTO;
import com.nova.dataservice.entity.ServiceMaster;

public interface ServiceMasterService {

	ServiceMaster saveServiceMaster(ServiceMaster serviceMaster);

	List<ServiceMasterDTO> findAllMaster();

	ServiceMasterDTO getMasterById(Long id);

}
