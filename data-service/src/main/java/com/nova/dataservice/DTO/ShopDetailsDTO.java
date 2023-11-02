package com.nova.dataservice.DTO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
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
public class ShopDetailsDTO {
	private Long id;
	
	private String shopName;
	
	private String shopAddress;
	
	private Long latitude;
	
	private Long longitude;
	
	private String email;
	
	private String phone;
	
	private LocalDate createdAt;
	
	private Boolean status;
	
	private Boolean isDeleted;
	
	private Boolean printerRequired;
	
	private String logo;
	
	private Boolean deviceRequired;
	
	private Boolean inventory;
	
	private Boolean enableGiftCard;
	
	private String pinCode;
	
	private Boolean shopCode;
	
	private String gstNo;
	
	private Long capacity;
	
	private String amenities;
	
	
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopAddress() {
		return shopAddress;
	}

	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}

	public Long getLatitude() {
		return latitude;
	}

	public void setLatitude(Long latitude) {
		this.latitude = latitude;
	}

	public Long getLongitude() {
		return longitude;
	}

	public void setLongitude(Long longitude) {
		this.longitude = longitude;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
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

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	

	public Boolean getPrinterRequired() {
		return printerRequired;
	}

	public void setPrinterRequired(Boolean printerRequired) {
		this.printerRequired = printerRequired;
	}

	public Boolean getDeviceRequired() {
		return deviceRequired;
	}

	public void setDeviceRequired(Boolean deviceRequired) {
		this.deviceRequired = deviceRequired;
	}

	public Boolean getInventory() {
		return inventory;
	}

	public void setInventory(Boolean inventory) {
		this.inventory = inventory;
	}

	public Boolean getEnableGiftCard() {
		return enableGiftCard;
	}

	public void setEnableGiftCard(Boolean enableGiftCard) {
		this.enableGiftCard = enableGiftCard;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public Boolean getShopCode() {
		return shopCode;
	}

	public void setShopCode(Boolean shopCode) {
		this.shopCode = shopCode;
	}

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	

}
