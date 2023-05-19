package com.nova.dataservice.entity;

import java.util.ArrayList;
import java.util.List;

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
}
