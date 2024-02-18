package com.nova.dataservice.DTO;

import java.time.LocalDate;

public class ShopDetailsDashboardDTO {
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
	
	private String ownerName;
	
	private Long ownerId;
	
	private String shopPhoto;
	
	private Float totalEarnings;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the shopName
	 */
	public String getShopName() {
		return shopName;
	}

	/**
	 * @param shopName the shopName to set
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	/**
	 * @return the shopAddress
	 */
	public String getShopAddress() {
		return shopAddress;
	}

	/**
	 * @param shopAddress the shopAddress to set
	 */
	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}

	/**
	 * @return the latitude
	 */
	public Long getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(Long latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public Long getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(Long longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the createdAt
	 */
	public LocalDate getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the status
	 */
	public Boolean getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}

	/**
	 * @return the isDeleted
	 */
	public Boolean getIsDeleted() {
		return isDeleted;
	}

	/**
	 * @param isDeleted the isDeleted to set
	 */
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	/**
	 * @return the printerRequired
	 */
	public Boolean getPrinterRequired() {
		return printerRequired;
	}

	/**
	 * @param printerRequired the printerRequired to set
	 */
	public void setPrinterRequired(Boolean printerRequired) {
		this.printerRequired = printerRequired;
	}

	/**
	 * @return the logo
	 */
	public String getLogo() {
		return logo;
	}

	/**
	 * @param logo the logo to set
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}

	/**
	 * @return the deviceRequired
	 */
	public Boolean getDeviceRequired() {
		return deviceRequired;
	}

	/**
	 * @param deviceRequired the deviceRequired to set
	 */
	public void setDeviceRequired(Boolean deviceRequired) {
		this.deviceRequired = deviceRequired;
	}

	/**
	 * @return the inventory
	 */
	public Boolean getInventory() {
		return inventory;
	}

	/**
	 * @param inventory the inventory to set
	 */
	public void setInventory(Boolean inventory) {
		this.inventory = inventory;
	}

	/**
	 * @return the enableGiftCard
	 */
	public Boolean getEnableGiftCard() {
		return enableGiftCard;
	}

	/**
	 * @param enableGiftCard the enableGiftCard to set
	 */
	public void setEnableGiftCard(Boolean enableGiftCard) {
		this.enableGiftCard = enableGiftCard;
	}

	/**
	 * @return the pinCode
	 */
	public String getPinCode() {
		return pinCode;
	}

	/**
	 * @param pinCode the pinCode to set
	 */
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	/**
	 * @return the shopCode
	 */
	public Boolean getShopCode() {
		return shopCode;
	}

	/**
	 * @param shopCode the shopCode to set
	 */
	public void setShopCode(Boolean shopCode) {
		this.shopCode = shopCode;
	}

	/**
	 * @return the gstNo
	 */
	public String getGstNo() {
		return gstNo;
	}

	/**
	 * @param gstNo the gstNo to set
	 */
	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	/**
	 * @return the capacity
	 */
	public Long getCapacity() {
		return capacity;
	}

	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(Long capacity) {
		this.capacity = capacity;
	}

	/**
	 * @return the amenities
	 */
	public String getAmenities() {
		return amenities;
	}

	/**
	 * @param amenities the amenities to set
	 */
	public void setAmenities(String amenities) {
		this.amenities = amenities;
	}

	/**
	 * @return the ownerId
	 */
	public Long getOwnerId() {
		return ownerId;
	}

	/**
	 * @param ownerId the ownerId to set
	 */
	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	/**
	 * @return the shopPhoto
	 */
	public String getShopPhoto() {
		return shopPhoto;
	}

	/**
	 * @param shopPhoto the shopPhoto to set
	 */
	public void setShopPhoto(String shopPhoto) {
		this.shopPhoto = shopPhoto;
	}

	/**
	 * @return the totalEarnings
	 */
	public Float getTotalEarnings() {
		return totalEarnings;
	}

	/**
	 * @param totalEarnings the totalEarnings to set
	 */
	public void setTotalEarnings(Float totalEarnings) {
		this.totalEarnings = totalEarnings;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	

}
