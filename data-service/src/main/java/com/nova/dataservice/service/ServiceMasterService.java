package com.nova.dataservice.service;

import java.util.List;
import java.util.Optional;

import com.nova.dataservice.entity.ServiceMaster;

public interface ServiceMasterService {

	ServiceMaster saveServiceMaster(ServiceMaster serviceMaster);

	List<ServiceMaster> findAllMaster();

	Optional<ServiceMaster> getMasterById(Long id);

	List<ServiceMaster> findServicesByNameContaining(String name);

}
