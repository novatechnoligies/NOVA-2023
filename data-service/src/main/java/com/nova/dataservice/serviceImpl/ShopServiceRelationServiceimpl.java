package com.nova.dataservice.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.dataservice.entity.ShopServiceRelation;
import com.nova.dataservice.repository.ShopServiceRelationRepository;
import com.nova.dataservice.service.ShopServiceRelationServices;

@Service
public class ShopServiceRelationServiceimpl implements ShopServiceRelationServices {
	
	@Autowired
	ShopServiceRelationRepository relationRepository;

	@Override
	public ShopServiceRelation saveShopServiceRelation(ShopServiceRelation serviceRelation) {
		// TODO Auto-generated method stub
		return relationRepository.save(serviceRelation);
	}

}
