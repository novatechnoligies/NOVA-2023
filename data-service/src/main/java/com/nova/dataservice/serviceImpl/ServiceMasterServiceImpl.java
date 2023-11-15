package com.nova.dataservice.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.dataservice.DTO.ServiceMasterDTO;
import com.nova.dataservice.DTO.ShopDetailsDTO;
import com.nova.dataservice.DTO.UserDetailsDTO;
import com.nova.dataservice.entity.ServiceMaster;
import com.nova.dataservice.entity.ShopDetails;
import com.nova.dataservice.entity.UserDetails;
import com.nova.dataservice.repository.ServiceMasterRepository;
import com.nova.dataservice.service.ServiceMasterService;

@Service
public class ServiceMasterServiceImpl implements ServiceMasterService{
	
	@Autowired
	ServiceMasterRepository serviceMasterRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ServiceMaster saveServiceMaster(ServiceMaster serviceMaster) {
		// TODO Auto-generated method stub
		return serviceMasterRepository.save(serviceMaster);
	}

	@Override
	public List<ServiceMasterDTO> findAllMaster() {
List<ServiceMaster> serviceMasterList = serviceMasterRepository.findAll(); // Retrieve a list of UserDetails entities
		
		List<ServiceMasterDTO> serviceMasterDTOList = serviceMasterList.stream()
		    .map(ServiceMaster -> modelMapper.map(ServiceMaster, ServiceMasterDTO.class))
		    .collect(Collectors.toList());
		return serviceMasterDTOList;

	}

	@Override
	public ServiceMasterDTO getMasterById(Long id) {
		// TODO Auto-generated method stub
		ServiceMasterDTO serviceMasterDTO = modelMapper.map(serviceMasterRepository.findById(id).get(), ServiceMasterDTO.class);
		return serviceMasterDTO;
		
		
		//return serviceMasterRepository.findById(id);
	}
}


