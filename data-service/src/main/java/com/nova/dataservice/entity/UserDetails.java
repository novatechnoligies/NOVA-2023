package com.nova.dataservice.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
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
@Table(name = "user_details")
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String pin;
	private String gender;
	private LocalDate createdAt;
	private Boolean status;
	private Boolean isDeleted;
	private Long ownerId;
	private String username;
	private String password;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id")
	private Role role;

	@OneToMany(mappedBy = "owner")
	private List<ShopDetails> shops = new ArrayList<>();

//	@OneToMany(mappedBy = "shop")
//	private List<SlotAvailability> timeAvailabilities = new ArrayList<>();

	
	

}