package com.nova.dataservice.dao;

import java.util.List;

import com.nova.dataservice.DTO.ServiceMasterDTO;

public interface ServiceDetaildao {

	List<ServiceMasterDTO> findAllServicesByLabId(Long labId);

}
