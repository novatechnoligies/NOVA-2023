package com.nova.dataservice.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.dataservice.DTO.ServiceMasterShopRelationDTO;
import com.nova.dataservice.DTO.ServiceMasterShoplistDto;
import com.nova.dataservice.entity.ServiceMaster;
import com.nova.dataservice.entity.ServiceMasterShopRelation;
import com.nova.dataservice.entity.ShopDetails;
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
		return relationRepository.save(serviceRelation);
	}

	@Override
	public List<ServiceMasterShopRelationDTO> findAllShopServiceRelation() {
		List<ServiceMasterShopRelation> serivceMastershopRelationList = relationRepository.findAll();
		List<ServiceMasterShopRelationDTO> serviceMasterShopDtoList = serivceMastershopRelationList.stream()
				.map(ServiceMasterShopRelation -> modelMapper.map(ServiceMasterShopRelation,
						ServiceMasterShopRelationDTO.class))
				.collect(Collectors.toList());
		return serviceMasterShopDtoList;
	}

	@Override
	public Optional<ServiceMasterShopRelation> shopServiceRelationfindById(Long id) {
		return relationRepository.findById(id);
	}

	@Override
	public List<ServiceMasterShopRelation> saveShopServiceList(List<ServiceMasterShopRelation> serviceRelation) {
		return relationRepository.saveAll(serviceRelation);
	}

	@Override
	public ServiceMasterShoplistDto saveServiceListForMultiShop(ServiceMasterShoplistDto serviceRelation) {
		for (Long shopId : serviceRelation.getShopIds()) {
			 for (ServiceMasterShopRelationDTO serviceMasterId : serviceRelation.getMasterShopRelationDTOs()) {
				 ServiceMasterShopRelation masterShopRelation = new ServiceMasterShopRelation();
				 
				 ServiceMaster seriveM = new ServiceMaster();
				 seriveM.setId(serviceMasterId.getId());
				 masterShopRelation.setService(seriveM );
				 ShopDetails shop = new ShopDetails();
				 shop.setId(shopId);
				 
				 masterShopRelation.setShop(shop);
				 masterShopRelation.setAmount(serviceMasterId.getAmount());
				 masterShopRelation.setCreatedDate(LocalDate.now());
				 masterShopRelation.setStatus(true);
				 relationRepository.save(masterShopRelation);
			}
		}
		return serviceRelation;
	}

}
