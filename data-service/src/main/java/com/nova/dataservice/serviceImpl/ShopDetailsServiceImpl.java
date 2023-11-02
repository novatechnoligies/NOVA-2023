package com.nova.dataservice.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.dataservice.DTO.ShopDetailsDTO;
import com.nova.dataservice.DTO.UserDetailsDTO;
import com.nova.dataservice.entity.ShopDetails;
import com.nova.dataservice.entity.UserDetails;
import com.nova.dataservice.repository.ShopDetailsRepository;
import com.nova.dataservice.service.ShopDetailsService;

@Service
public class ShopDetailsServiceImpl implements ShopDetailsService {
	
	@Autowired
	ShopDetailsRepository detailsRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public ShopDetails saveShopDetails(ShopDetails details) {
		details.setCreatedAt(LocalDate.now());
		details.setStatus(true);
		details.setIsDeleted(false);
	return	detailsRepository.save(details);
	}

	@Override
	public List<ShopDetailsDTO> findAllShopDetails() {
		// TODO Auto-generated method stub
List<ShopDetails> shopDetailsList = detailsRepository.findAll(); // Retrieve a list of UserDetails entities
		
		List<ShopDetailsDTO> shopDetailsDTOList = shopDetailsList.stream()
		    .map(userDetails -> modelMapper.map(userDetails, ShopDetailsDTO.class))
		    .collect(Collectors.toList());
		return shopDetailsDTOList;
	//	return detailsRepository.findAll();
	}

	@Override
	public Optional<ShopDetailsDTO> findByIdShopDetails(Long id) {
		// TODO Auto-generated method stub
		ShopDetailsDTO shopDetailsDTO = modelMapper.map(detailsRepository.findById(id).get(), ShopDetailsDTO.class);
		return Optional.of(shopDetailsDTO);	}

}
