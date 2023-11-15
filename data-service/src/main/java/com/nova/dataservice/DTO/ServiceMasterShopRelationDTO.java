package com.nova.dataservice.DTO;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

public class ServiceMasterShopRelationDTO {

    private Long id;
	
	private Boolean status;
	
	private Float amount;
	
	private LocalDate createdDate;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "shop_id")
//    private ShopDetails shop;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "service_id")
//    private ServiceMaster service;
	

    public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
//	public ShopDetails getShop() {
//		return shop;
//	}
//
//	public void setShop(ShopDetails shop) {
//		this.shop = shop;
//	}
//	public ServiceMaster getService() {
//		return service;
//	}
//
//	public void setService(ServiceMaster service) {
//		this.service = service;
//	}
//    
    
}
