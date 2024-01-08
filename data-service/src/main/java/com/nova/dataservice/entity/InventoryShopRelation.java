package com.nova.dataservice.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name="inventory_shop_relation")
public class InventoryShopRelation {

	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	

	@Column(name="unit")
	private Long unit;
	
	@Column(name="created_at")
	private LocalDate createdAt;
	
	@Column(name="status")
	private Boolean status;
	
	@Column(name="qty")
	private Long quantity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "inventory_id")
	private MasterInventory inventory;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "shop_id")
	@JsonIgnore
	private ShopDetails shopDetails;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MasterInventory getInventory() {
		return inventory;
	}

	public void setInventory(MasterInventory inventory) {
		this.inventory = inventory;
	}

	public ShopDetails getShopDetails() {
		return shopDetails;
	}

	public void setShopDetails(ShopDetails shopDetails) {
		this.shopDetails = shopDetails;
	}

	public Long getUnit() {
		return unit;
	}

	public void setUnit(Long unit) {
		this.unit = unit;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

}
