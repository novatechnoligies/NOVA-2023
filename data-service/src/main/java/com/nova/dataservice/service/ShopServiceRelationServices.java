package com.nova.dataservice.service;


import java.util.List;
import java.util.Optional;

import com.nova.dataservice.DTO.ServiceMasterShopRelationDTO;
import com.nova.dataservice.entity.ServiceMasterShopRelation;

public interface ShopServiceRelationServices {

	ServiceMasterShopRelation saveShopServiceRelation(ServiceMasterShopRelation serviceRelation);

	List<ServiceMasterShopRelationDTO> findAllShopServiceRelation();

	Optional<ServiceMasterShopRelation> shopServiceRelationfindById(Long id);

}
