package com.nova.dataservice.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.dataservice.entity.ShopUpdateRequest;
import com.nova.dataservice.repository.ShopUpdateRequestRepo;
import com.nova.dataservice.service.ShopUpdateRequestService;

@Service
public class ShopUpdateRequestServiceImpl implements ShopUpdateRequestService {
	
	@Autowired
	ShopUpdateRequestRepo repo;

	@Override
	public ShopUpdateRequest saveShopUpdateRequest(ShopUpdateRequest request) {
		// TODO Auto-generated method stub
		return repo.save(request);
	}

}
