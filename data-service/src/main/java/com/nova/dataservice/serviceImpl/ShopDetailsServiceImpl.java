package com.nova.dataservice.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.dataservice.DTO.ShopDetailsDTO;
import com.nova.dataservice.DTO.ShopDetailsDashboardDTO;
import com.nova.dataservice.dao.ShopDetailsDao;
import com.nova.dataservice.dao.UserServiceDao;
import com.nova.dataservice.entity.ShopDetails;
import com.nova.dataservice.entity.UserDetails;
import com.nova.dataservice.repository.ShopDetailsRepository;
import com.nova.dataservice.repository.UserDetailsRepository;
import com.nova.dataservice.service.ShopDetailsService;

@Service
public class ShopDetailsServiceImpl implements ShopDetailsService {
	
	@Autowired 
	ShopDetailsRepository detailsRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	UserServiceDao userServiceDao; 
	
	
	@Autowired
	UserDetailsRepository userDetailsRepository;
	
	@Autowired
	ShopDetailsDao shopDao;
	
	
	
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
		UserDetails owner = userDetailsRepository.findById(ownerId).get();
		
		List<ShopDetails> shopDetails = null;
		if (owner.getRole().getId()==1l) {
			shopDetails = detailsRepository.findByOwnerAndIsDeleted(owner, false);
			List<ShopDetailsDTO> shopDetailsDTOList = shopDetails.stream()
					.map(shopDe -> modelMapper.map(shopDe, ShopDetailsDTO.class)).collect(Collectors.toList());
			return shopDetailsDTOList;
		} else {
			List<ShopDetailsDTO> shopDetailsDTOList = userServiceDao.findByShopAccessByEmployeeAndIsDeleted(ownerId, true);
			
//			List<ShopDetailsDTO> shopDetailsDTOList1 = shopDetails.stream()
//					.map(shopDe -> modelMapper.map(shopDe, ShopDetailsDTO.class)).collect(Collectors.toList());
			return shopDetailsDTOList;
		}
	}

	@Override
	public List<ShopDetailsDTO> getAllLabListForTabletByOwnerId(Long ownerId) {
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

	@Override
	public Optional<ShopDetails> findById(Long shopId) {
		return detailsRepository.save(shopId);
	}

	@Override
	public List<ShopDetailsDashboardDTO> getAllLabListInDashboardByOwnerId(Long ownerId) {
		// TODO Auto-generated method stub
		  List<ShopDetailsDashboardDTO> ShopDetailDto2List  = shopDao.findAllLabListByOwnerId1(ownerId);
		  return ShopDetailDto2List;
	}

	

}
