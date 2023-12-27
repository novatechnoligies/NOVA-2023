package com.nova.dataservice.DTO;

import java.time.LocalDate;
import java.time.LocalTime;


public class SlotAvailabilityDTO {
	
	private Long id;
	private String appStatus;
	private LocalTime slot;
	private Long shopId;
	private LocalDate appDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAppStatus() {
		return appStatus;
	}
	public void setAppStatus(String appStatus) {
		this.appStatus = appStatus;
	}
	public LocalTime getSlot() {
		return slot;
	}
	public void setSlot(LocalTime slot) {
		this.slot = slot;
	}
	public Long getShopId() {
		return shopId;
	}
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
	public LocalDate getAppDate() {
		return appDate;
	}
	public void setAppDate(LocalDate appDate) {
		this.appDate = appDate;
	}
}
