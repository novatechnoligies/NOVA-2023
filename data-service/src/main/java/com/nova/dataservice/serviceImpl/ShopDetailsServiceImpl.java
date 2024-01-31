package com.nova.dataservice.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.dataservice.DTO.ShopDetailsDTO;
import com.nova.dataservice.dao.UserServiceDao;
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
	
	@Autowired
	UserServiceDao userServiceDao;
	
	
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
				.map(shopDe -> modelMapper.map(shopDe, ShopDetailsDTO.class)).collect(Collectors.toList());
		return shopDetailsDTOList;
		// return detailsRepository.findAll();
	}

	@Override
	public Optional<ShopDetailsDTO> findByIdShopDetails(Long id) {
		// TODO Auto-generated method stub
		ShopDetailsDTO shopDetailsDTO = modelMapper.map(detailsRepository.findById(id).get(), ShopDetailsDTO.class);
		return Optional.of(shopDetailsDTO);	}

	@Override
	public List<ShopDetailsDTO> searchLabByNameAndOwner(String labName, Long ownerId) {
		List<ShopDetails> shopDetailsList = detailsRepository.searchLabByNameAndOwner(labName); // Retrieve a list of UserDetails entities

		List<ShopDetailsDTO> shopDetailsDTOList = shopDetailsList.stream()
				.map(shopDe -> modelMapper.map(shopDe, ShopDetailsDTO.class)).collect(Collectors.toList());
		return shopDetailsDTOList;
		// return detailsRepository.findAll();
	}

	@Override
	public List<ShopDetailsDTO> getAllLabListByOwnerId(Long ownerId) {
		// TODO Auto-generated method stub
		UserDetails owner = new UserDetails();
		owner.setId(ownerId);
		
		//return userServiceDao.getAllLabListByOwnerId(ownerId);
		List<ShopDetails> shopDetails = detailsRepository.findByOwner(owner);
		
		List<ShopDetailsDTO> shopDetailsDTOList = shopDetails.stream()
				.map(shopDe -> modelMapper.map(shopDe, ShopDetailsDTO.class)).collect(Collectors.toList());
		return shopDetailsDTOList;
	}

	@Override
	public List<ShopDetailsDTO> getAllLabListForTabletByOwnerId(Long ownerId) {
		// TODO Auto-generated method stub
		return userServiceDao.getAllLabListByOwnerId(ownerId);
		//return null;
	}

	@Override
	public ShopDetails deleteShopDetails(Long shopId) {
		Optional<ShopDetails> shopDetails = detailsRepository.findById(shopId);
		if (shopDetails.isPresent()) {
			shopDetails.get().setIsDeleted(true);
			detailsRepository.save(shopDetails.get());
		}
		return shopDetails.get();
	}

}
