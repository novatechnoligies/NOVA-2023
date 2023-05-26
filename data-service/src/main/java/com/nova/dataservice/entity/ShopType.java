package com.nova.dataservice.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "shop_type")
public class ShopType {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String type;
	
	@OneToMany(mappedBy = "shopType")
    private List<ShopDetails> shopDetails = new ArrayList<>();
 @Column
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@Column

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	@Column

	public List<ShopDetails> getShopDetails() {
		return shopDetails;
	}

	public void setShopDetails(List<ShopDetails> shopDetails) {
		this.shopDetails = shopDetails;
	}
	
	
}
