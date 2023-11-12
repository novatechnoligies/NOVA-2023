package com.nova.dataservice.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.dataservice.DTO.ServiceMasterShopRelationDTO;
import com.nova.dataservice.DTO.ShopRatingDTO;
import com.nova.dataservice.DTO.UserDetailsDTO;
import com.nova.dataservice.entity.ServiceMaster;
import com.nova.dataservice.entity.ServiceMasterShopRelation;
import com.nova.dataservice.entity.ShopRating;
import com.nova.dataservice.entity.UserDetails;
import com.nova.dataservice.repository.ShopServiceRelationRepository;
import com.nova.dataservice.service.ShopServiceRelationServices;

@Service
public class ShopServiceRelationServiceimpl implements ShopServiceRelationServices {
	
	@Autowired
	ShopServiceRelationRepository relationRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ServiceMasterShopRelation saveShopServiceRelation(ServiceMasterShopRelation serviceRelation) {
		// TODO Auto-generated method stub
		return relationRepository.save(serviceRelation);
	}

	@Override
	public List<ServiceMasterShopRelationDTO> findAllShopServiceRelation() {
List<ServiceMasterShopRelation> serivceMastershopRelationList = relationRepository.findAll(); // Retrieve a list of UserDetails entities
		
		List<ServiceMasterShopRelationDTO> serviceMasterShopDtoList = serivceMastershopRelationList.stream()
		    .map(ServiceMasterShopRelation -> modelMapper.map(ServiceMasterShopRelation, ServiceMasterShopRelationDTO.class))
		    .collect(Collectors.toList());
		return serviceMasterShopDtoList;
		//return relationRepository.findAll();
	}

	@Override
	public Optional<ServiceMasterShopRelation> shopServiceRelationfindById(Long id) {
		// TODO Auto-generated method stub
		return relationRepository.findById(id);
	}

}
