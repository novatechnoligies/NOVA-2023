package com.nova.dataservice.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.dataservice.entity.ShopDetails;
import com.nova.dataservice.repository.ShopDetailsRepository;
import com.nova.dataservice.service.ShopDetailsServices;

@Service
public class SopDetailsServicesimpl implements ShopDetailsServices {
	
	@Autowired
	ShopDetailsRepository detailsRepository;

	@Override
	public ShopDetails saveShopDetails(ShopDetails details) {
		// TODO Auto-generated method stub
		return detailsRepository.save(details);
	}

}
