package com.nova.demo.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.demo.DTO.AppShopConsumerOwnerDetails;
import com.nova.demo.repository.UserDetailsRepo;
import com.nova.demo.service.AppConOwnShopService;

@Service
public class AppConOwnShopServiceImpl implements AppConOwnShopService {

	@Autowired
	
	UserDetailsRepo detailsRepo;
	
	@Override
	public List<AppShopConsumerOwnerDetails> getAllAppoinmentByShopIdAndDate(Long shopId, LocalDate date) {
		// TODO Auto-generated method stub
		return detailsRepo.getAllAppoinmentByShopIdAndDate(shopId,date) ;
	}

}
