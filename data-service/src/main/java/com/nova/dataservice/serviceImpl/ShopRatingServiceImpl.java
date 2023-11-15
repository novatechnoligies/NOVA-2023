package com.nova.dataservice.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.dataservice.DTO.ServiceMasterDTO;
import com.nova.dataservice.DTO.ShopRatingDTO;
import com.nova.dataservice.entity.ServiceMaster;
import com.nova.dataservice.entity.ShopRating;
import com.nova.dataservice.repository.ShopRatingRepository;
import com.nova.dataservice.service.ShopRatingService;

@Service
public class ShopRatingServiceImpl implements ShopRatingService{
	
	@Autowired
	ShopRatingRepository ratingRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ShopRating saveRating(ShopRating shopRating) {
		
		return ratingRepository.save(shopRating);
	}

	@Override
	public List<ShopRatingDTO> findAllShopRataing() {
List<ShopRating> serviceMasterList = ratingRepository.findAll(); // Retrieve a list of UserDetails entities
		
		List<ShopRatingDTO> shopratingList = serviceMasterList.stream()
		    .map(ServiceMaster -> modelMapper.map(ServiceMaster, ShopRatingDTO.class))
		    .collect(Collectors.toList());
		return shopratingList;
		//return ratingRepository.findAll();
	}

	@Override
	public Optional<ShopRating> getShopRatingById(long id) {
		// TODO Auto-generated method stub
		return ratingRepository.findById(id);
	}

	
	}


