//package com.nova.dataservice.entity;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.Table;
//@Entity
//@Table(name = "locations_details")
//public class LocationDetails {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "id")
//	private Long id;
//	
//	@Column(name = "location_name")
//	private String location;
//	
//	@Column(name = "location_address")
//	private String locationAddress;
//	
//	@Column(name = "latitude")
//	private Long latitude;
//	
//	@Column(name = "longitude")
//	private Long longitude;
//	
//	@Column(name = "email")
//	private String email;
//	
//	@Column(name = "phone")
//	private String phone;
//	
//	@Column(name = "created_at")
//	private LocalDate createdAt;
//	
//	@Column(name = "status")
//	private Boolean status;
//	
//	@Column(name = "is_deleted")
//	private Boolean isDeleted;
//
//	@Column(name = "logo")
//	private String logo;
//	
//	@Column(name = "pin_code")
//	private String pinCode;
//	
//	@Column(name = "location_code")
//	private Boolean locationCode;
//	
//	@Column(name = "gst_no")
//	private String gstNo;
//	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "user_id")
//	@JsonIgnore
//	private UserDetails owner;
//	
//	@OneToMany(mappedBy = "shop")
//	@JsonIgnore
//	private List<ShopDetails> shopDetails = new ArrayList<>();
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getLocation() {
//		return location;
//	}
//
//	public void setLocation(String location) {
//		this.location = location;
//	}
//
//	public String getLocationAddress() {
//		return locationAddress;
//	}
//
//	public void setLocationAddress(String locationAddress) {
//		this.locationAddress = locationAddress;
//	}
//
//	public Long getLatitude() {
//		return latitude;
//	}
//
//	public void setLatitude(Long latitude) {
//		this.latitude = latitude;
//	}
//
//	public Long getLongitude() {
//		return longitude;
//	}
//
//	public void setLongitude(Long longitude) {
//		this.longitude = longitude;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getPhone() {
//		return phone;
//	}
//
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
//
//	public LocalDate getCreatedAt() {
//		return createdAt;
//	}
//
//	public void setCreatedAt(LocalDate createdAt) {
//		this.createdAt = createdAt;
//	}
//
//	public Boolean getStatus() {
//		return status;
//	}
//
//	public void setStatus(Boolean status) {
//		this.status = status;
//	}
//
//	public Boolean getIsDeleted() {
//		return isDeleted;
//	}
//
//	public void setIsDeleted(Boolean isDeleted) {
//		this.isDeleted = isDeleted;
//	}
//
//	public String getLogo() {
//		return logo;
//	}
//
//	public void setLogo(String logo) {
//		this.logo = logo;
//	}
//
//	public String getPinCode() {
//		return pinCode;
//	}
//
//	public void setPinCode(String pinCode) {
//		this.pinCode = pinCode;
//	}
//
//	public Boolean getLocationCode() {
//		return locationCode;
//	}
//
//	public void setLocationCode(Boolean locationCode) {
//		this.locationCode = locationCode;
//	}
//
//	public String getGstNo() {
//		return gstNo;
//	}
//
//	public void setGstNo(String gstNo) {
//		this.gstNo = gstNo;
//	}
//
//	public UserDetails getOwner() {
//		return owner;
//	}
//
//	public void setOwner(UserDetails owner) {
//		this.owner = owner;
//	}
//
//	public List<ShopDetails> getShopDetails() {
//		return shopDetails;
//	}
//
//	public void setShopDetails(List<ShopDetails> shopDetails) {
//		this.shopDetails = shopDetails;
//	}
//
//	
//
//	
//
//}
