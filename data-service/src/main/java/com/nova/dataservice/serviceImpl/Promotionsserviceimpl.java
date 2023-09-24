package com.nova.dataservice.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.dataservice.entity.Pramotions;
import com.nova.dataservice.entity.Role;
import com.nova.dataservice.repository.PromotionsRepository;
import com.nova.dataservice.service.PromotionsServices;

import jakarta.transaction.Transactional;
@Service
public class Promotionsserviceimpl implements PromotionsServices {

	@Autowired
	PromotionsRepository promotionsRepository;
	
	@Override
	public Pramotions Savepromotion(Pramotions pramotions) {
		return promotionsRepository.save(pramotions);
	}
	

	@Override
	public List<Pramotions> findAllPromotions() {
		// TODO Auto-generated method stub
		return promotionsRepository.findAll();
	}


	@Override
	public Optional<Pramotions> getPromotionById(Long id) {
		// TODO Auto-generated method stub
		return promotionsRepository.findById(id);
	}


	@Transactional
	public Optional<Pramotions> getPromotionByshopId(Long id) {
		// TODO Auto-generated method stub
		return promotionsRepository.findByShopId(id);
	}

	
	
}
