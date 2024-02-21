package com.nova.dataservice.service;


import java.util.List;
import java.util.Optional;

import com.nova.dataservice.DTO.ServiceDetailDTO;
import com.nova.dataservice.DTO.ServiceMasterShopRelationDTO;
import com.nova.dataservice.DTO.ServiceMasterShoplistDto;
import com.nova.dataservice.entity.ServiceMasterShopRelation;
import com.nova.dataservice.entity.ShopDetails;

public interface ShopServiceRelationServices {

	ServiceMasterShopRelation saveShopServiceRelation(ServiceMasterShopRelation serviceRelation);

	List<ServiceMasterShopRelationDTO> findAllShopServiceRelation();

	Optional<ServiceMasterShopRelation> shopServiceRelationfindById(Long id);

	List<ServiceMasterShopRelation> saveShopServiceList(List<ServiceMasterShopRelation> serviceRelation);

	ServiceMasterShoplistDto saveServiceListForMultiShop(ServiceMasterShoplistDto serviceRelation);

	List<ServiceDetailDTO> findAllShopServiceByLab(Long labId,String service);

	List<ServiceDetailDTO> findAllShopServiceByLab(Long labId);

	ServiceMasterShopRelation updatedServicePrice(Long serviceId, Float newPrice);

}
