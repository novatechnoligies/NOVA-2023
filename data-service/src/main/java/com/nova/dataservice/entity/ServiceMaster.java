package com.nova.dataservice.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "service_master")
public class ServiceMaster {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
    private Long id;

	@Column(name = "name")
    private String name;
	

	@OneToMany(mappedBy = "service")
	@JsonIgnore
    private List<ShopServiceRelation> shopServices = new ArrayList<>();


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<ShopServiceRelation> getShopServices() {
		return shopServices;
	}


	public void setShopServices(List<ShopServiceRelation> shopServices) {
		this.shopServices = shopServices;
	}
	
	
}
