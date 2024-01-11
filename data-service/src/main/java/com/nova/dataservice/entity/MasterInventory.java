package com.nova.dataservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="master_inventory")
public class MasterInventory {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="id")
	private Long id;
	
	@Column(name="name")
	private  String name;
	
	@Column(name="type")
	private String type;
	
	@Column(name="status")
	private Boolean status;
	
	@Column(name="amount")
	private float amount;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

}
