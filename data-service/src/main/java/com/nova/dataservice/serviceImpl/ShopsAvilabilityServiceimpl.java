package com.nova.dataservice.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.dataservice.entity.ShopAvalibility;
import com.nova.dataservice.repository.ShopsAvilabilityRepository;
import com.nova.dataservice.service.ShopsAvilabilityService;

@Service
public class ShopsAvilabilityServiceimpl implements ShopsAvilabilityService {
	
	@Autowired
	ShopsAvilabilityRepository avilabilityRepository;
	
	@Override
	public ShopAvalibility saveShopAvailability(ShopAvalibility avalibility) {
		return avilabilityRepository.save(avalibility) ;
	}

	@Override
	public List<ShopAvalibility> findAllShopAvailability() {
		// TODO Auto-generated method stub
		return avilabilityRepository.findAll();
	}

	@Override
	public Optional<ShopAvalibility> getShopAvaibilityById(Long id) {
		// TODO Auto-generated method stub
		return avilabilityRepository.findById(id);
	}

}
