package com.nova.Owner.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.Owner.DTO.ServiceMasterParameterDTO;
import com.nova.Owner.DTO.ShopSummaryByDTO;
import com.nova.Owner.Dao.ShopSummaryDAO;
import com.nova.Owner.Service.ShopSummaryService;
@Service

public class ShopSummaryServiceImpl implements ShopSummaryService {
	@Autowired
	ShopSummaryDAO dao;

	@Override
	public List<ShopSummaryByDTO> getShopSummaryById(Long shop_id) {
		// TODO Auto-generated method stub
		return dao.getShopSummaryById(shop_id);
	}

	@Override
	public List<ServiceMasterParameterDTO> getByServiceMasterName(Long serviceMasterId) {
		// TODO Auto-generated method stub
		return dao.getByServiceMasterName(serviceMasterId);
	}

}
