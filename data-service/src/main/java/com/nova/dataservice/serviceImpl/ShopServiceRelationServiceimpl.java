package com.nova.dataservice.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.dataservice.entity.ServiceMasterShopRelation;
import com.nova.dataservice.repository.ShopServiceRelationRepository;
import com.nova.dataservice.service.ShopServiceRelationServices;

@Service
public class ShopServiceRelationServiceimpl implements ShopServiceRelationServices {
	
	@Autowired
	ShopServiceRelationRepository relationRepository;

	@Override
	public ServiceMasterShopRelation saveShopServiceRelation(ServiceMasterShopRelation serviceRelation) {
		// TODO Auto-generated method stub
		return relationRepository.save(serviceRelation);
	}

	@Override
	public List<ServiceMasterShopRelation> findAllShopServiceRelation() {
		// TODO Auto-generated method stub
		return relationRepository.findAll();
	}

	@Override
	public Optional<ServiceMasterShopRelation> shopServiceRelationfindById(Long id) {
		// TODO Auto-generated method stub
		return relationRepository.findById(id);
	}

}
