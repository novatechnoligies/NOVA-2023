package com.nova.dataservice.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.dataservice.entity.ShopDetails;
import com.nova.dataservice.repository.ShopDetailsRepository;
import com.nova.dataservice.service.ShopDetailsService;

@Service
public class ShopDetailsServiceImpl implements ShopDetailsService {
	
	@Autowired
	ShopDetailsRepository detailsRepository;

	@Override
	public ShopDetails saveShopDetails(ShopDetails details) {
		details.setCreatedAt(LocalDate.now());
		details.setStatus(true);
		details.setIsDeleted(false);
	return	detailsRepository.save(details);
	}

	@Override
	public List<ShopDetails> findAllShopDetails() {
		// TODO Auto-generated method stub
		return detailsRepository.findAll();
	}

	@Override
	public Optional<ShopDetails> findByIdShopDetails(Long id) {
		// TODO Auto-generated method stub
		return detailsRepository.findById(id);
	}

}
