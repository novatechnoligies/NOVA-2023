package com.nova.demo.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "shop_details")
public class ShopDetails {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String shopName;
    private String shopAddress;
    private Long latitude;
    private Long longitude;
    private String email;
    private String phone;
    private String logo;
    private LocalDate createdAt;
    private Boolean status;
    private Boolean isDeleted;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_type_id")
    private ShopType shopType; 
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserDetails owner;
    
    @OneToMany(mappedBy = "shop")
    private List<ShopAvalibility> timeAvailabilities = new ArrayList<>();
    
    @OneToMany(mappedBy = "shop")
    private List<ShopServiceRelation> shopServices = new ArrayList<>();

}
