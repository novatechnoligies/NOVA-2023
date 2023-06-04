package com.nova.demo.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.demo.DTO.AppShopConsumerOwnerDetails;
import com.nova.demo.dao.AppShopConsumerOwnerDetailsDao;
import com.nova.demo.service.AppConOwnShopService;

@Service
public class AppConOwnShopServiceImpl implements AppConOwnShopService {

	@Autowired
	AppShopConsumerOwnerDetailsDao dao;
	
	@Override
	public List<AppShopConsumerOwnerDetails> getAllAppoinmentByShopIdAndDate(Long shopId, LocalDate date) {
		// TODO Auto-generated method stub
		List<AppShopConsumerOwnerDetails> data = dao.getAllAppoinmentByShopIdAndDate(shopId,date) ;
        return data;
	}

}
