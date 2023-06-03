package com.nova.demo.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppShopConsumerOwnerDetails {

	private LocalDate appoinmentDate;
	
	private LocalTime appoinmentTime;
	
	private Long slotId;
	
	private String appoinmentStatus;
	
	private String shopName;
	
	private String shopAddress;
	
	private String shopPhone;
	
	private Long latitude;
	
	private Long longitude;
	
	private Long consumerId;
	
	private String consumerName;
	
	private String consumerPhone;
	
	private Long onwerId;
	
	private String ownerName;
	
	private  String ownerPhone;

	public LocalDate getAppoinmentDate() {
		return appoinmentDate;
	}

	public void setAppoinmentDate(LocalDate appoinmentDate) {
		this.appoinmentDate = appoinmentDate;
	}

	public LocalTime getAppoinmentTime() {
		return appoinmentTime;
	}

	public void setAppoinmentTime(LocalTime appoinmentTime) {
		this.appoinmentTime = appoinmentTime;
	}

	public Long getSlotId() {
		return slotId;
	}

	public void setSlotId(Long slotId) {
		this.slotId = slotId;
	}

	public String getAppoinmentStatus() {
		return appoinmentStatus;
	}

	public void setAppoinmentStatus(String appoinmentStatus) {
		this.appoinmentStatus = appoinmentStatus;
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

	public String getShopPhone() {
		return shopPhone;
	}

	public void setShopPhone(String shopPhone) {
		this.shopPhone = shopPhone;
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

	public Long getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(Long consumerId) {
		this.consumerId = consumerId;
	}

	public String getConsumerName() {
		return consumerName;
	}

	public void setConsumerName(String consumerName) {
		this.consumerName = consumerName;
	}

	public String getConsumerPhone() {
		return consumerPhone;
	}

	public void setConsumerPhone(String consumerPhone) {
		this.consumerPhone = consumerPhone;
	}

	public Long getOnwerId() {
		return onwerId;
	}

	public void setOnwerId(Long onwerId) {
		this.onwerId = onwerId;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerPhone() {
		return ownerPhone;
	}

	public void setOwnerPhone(String ownerPhone) {
		this.ownerPhone = ownerPhone;
	}
	
	
}
