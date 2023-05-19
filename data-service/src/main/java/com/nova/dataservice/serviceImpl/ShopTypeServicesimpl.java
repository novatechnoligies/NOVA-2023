package com.nova.dataservice.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.dataservice.entity.ShopType;
import com.nova.dataservice.repository.ShopTypeRepository;
import com.nova.dataservice.service.ShopTypeServices;

@Service
public class ShopTypeServicesimpl implements ShopTypeServices {
	
	@Autowired
	ShopTypeRepository repository;

	@Override
	public ShopType saveShopType(ShopType shopType) {
		// TODO Auto-generated method stub
		return repository.save(shopType);
	}

}
