package com.nova.Owner.Service;

import java.util.List;

import com.nova.Owner.DTO.ServiceMasterParameterDTO;
import com.nova.Owner.DTO.ShopSummaryByDTO;

public interface ShopSummaryService {

	List<ShopSummaryByDTO> getShopSummaryById(Long shop_id);

	List<ServiceMasterParameterDTO> getByServiceMasterName(Long serviceMasterId);

}
