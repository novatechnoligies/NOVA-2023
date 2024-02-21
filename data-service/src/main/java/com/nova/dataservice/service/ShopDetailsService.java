package com.nova.dataservice.service;

import java.util.List;
import java.util.Optional;

import com.nova.dataservice.DTO.ShopDetailsDTO;
import com.nova.dataservice.DTO.ShopDetailsDashboardDTO;
import com.nova.dataservice.entity.ShopDetails;

public interface ShopDetailsService {

	ShopDetails saveShopDetails(ShopDetails details);

	List<ShopDetailsDTO> findAllShopDetails();

	Optional<ShopDetailsDTO> findByIdShopDetails(Long id);

	List<ShopDetailsDTO> searchLabByNameAndOwner(String labName, Long ownerId);

	List<ShopDetailsDTO> getAllLabListByOwnerId(Long ownerId);

	List<ShopDetailsDTO> getAllLabListForTabletByOwnerId(Long ownerId);

	ShopDetails deleteShopDetails(Long shopId);

	Optional<ShopDetails> findById(Long shopId);

	List<ShopDetailsDashboardDTO> getAllLabListInDashboardByOwnerId(Long ownerId);



}
