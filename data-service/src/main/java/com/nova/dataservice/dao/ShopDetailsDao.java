package com.nova.dataservice.dao;

import java.util.List;

import com.nova.dataservice.DTO.ShopDetailsDashboardDTO;

public interface ShopDetailsDao {

	List<ShopDetailsDashboardDTO> findAllLabListByOwnerId1(Long ownerId);
	

}
