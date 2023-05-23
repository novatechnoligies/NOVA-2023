package com.nova.dataservice.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.dataservice.entity.ShopServiceRelation;
import com.nova.dataservice.repository.ShopServiceRelationRepository;
import com.nova.dataservice.service.ShopServiceRelationServices;

@Service
public abstract class ShopServiceRelationServiceimpl implements ShopServiceRelationServices {
	
	@Autowired
	ShopServiceRelationRepository relationRepository;

	@Override
	public ShopServiceRelation saveShopServiceRelation(ShopServiceRelation serviceRelation) {
		// TODO Auto-generated method stub
		return relationRepository.save(serviceRelation);
	}

	@Override
	public List<ShopServiceRelation> findAllShopServiceRelation() {
		// TODO Auto-generated method stub
		return relationRepository.findAll();
	}

	@Override
	public Optional<ShopServiceRelation> shopServiceRelationfindById(long id) {
		// TODO Auto-generated method stub
		return relationRepository.findById(id);
	}

}
