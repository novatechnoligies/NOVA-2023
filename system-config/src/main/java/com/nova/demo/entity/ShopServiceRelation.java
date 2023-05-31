package com.nova.demo.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "shop_Service_relation")
public class ShopServiceRelation {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
    private ShopDetails shop;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id")
    private ServiceMaster service;
    
  @Column
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@Column

	public ShopDetails getShop() {
		return shop;
	}

	public void setShop(ShopDetails shop) {
		this.shop = shop;
	}
	@Column

	public ServiceMaster getService() {
		return service;
	}

	public void setService(ServiceMaster service) {
		this.service = service;
	}
    
    
}
