package com.nova.dataservice.serviceImpl;

import java.time.LocalDate;
import java.util.Date;
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
	
	@Transactional
	public Pramotions Savepromotion(Pramotions pramotions) {
		pramotions.setStatus(true);
		pramotions.setCreatedAt(LocalDate.now());
		pramotions.setIsDeleted(false);
		return promotionsRepository.save(pramotions);
	}
	

	@Transactional
	public List<Pramotions> findAllPromotions() {
		// TODO Auto-generated method stub
		return promotionsRepository.findAll();
	}


	@Transactional
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
