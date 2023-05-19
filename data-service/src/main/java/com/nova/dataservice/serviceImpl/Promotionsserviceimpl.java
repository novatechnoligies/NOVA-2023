package com.nova.dataservice.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.dataservice.entity.Pramotions;
import com.nova.dataservice.entity.Role;
import com.nova.dataservice.repository.PromotionsRepository;
import com.nova.dataservice.service.PromotionsServices;
@Service
public class Promotionsserviceimpl implements PromotionsServices {

	@Autowired
	PromotionsRepository promotionsRepository;
	
	@Override
	public Pramotions Savepromotion(Pramotions pramotions) {
		return promotionsRepository.save(pramotions);
	}
}
