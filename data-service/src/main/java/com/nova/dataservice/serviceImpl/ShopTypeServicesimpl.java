package com.nova.dataservice.serviceImpl;

import java.util.List;
import java.util.Optional;

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

	@Override
	public List<ShopType> findAllshopType() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<ShopType> getById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

}
