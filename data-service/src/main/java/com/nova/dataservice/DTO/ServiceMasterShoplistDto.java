package com.nova.dataservice.DTO;

import java.time.LocalDate;
import java.util.List;

import com.nova.dataservice.entity.ServiceMasterShopRelation;

public class ServiceMasterShoplistDto {
	
	private List<Long> shopIds;
	
	private List<ServiceMasterShopRelationDTO> masterShopRelationDTOs;

	public List<Long> getShopIds() {
		return shopIds;
	}

	public void setShopIds(List<Long> shopIds) {
		this.shopIds = shopIds;
	}

	public List<ServiceMasterShopRelationDTO> getMasterShopRelationDTOs() {
		return masterShopRelationDTOs;
	}

	public void setMasterShopRelationDTOs(List<ServiceMasterShopRelationDTO> masterShopRelationDTOs) {
		this.masterShopRelationDTOs = masterShopRelationDTOs;
	}

}
