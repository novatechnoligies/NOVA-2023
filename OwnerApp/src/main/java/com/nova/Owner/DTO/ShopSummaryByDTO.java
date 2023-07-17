package com.nova.Owner.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class ShopSummaryByDTO {
	
	private Long shopId;
	
	private String phone;
	
	private String shopAddress;
	
	private String email;
	
	private LocalDate fromDate;
	
	private LocalDate toDate;
	
	private LocalTime fromTime;
	
	private LocalTime toTime;
	
	private String shopTypeName;
	
	private String serviceName;
	
	private Float serviceAmount;

	public Long getId() {
		return shopId;
	}

	public void setId(Long id) {
		this.shopId = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getShopAddress() {
		return shopAddress;
	}

	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	public LocalTime getFromTime() {
		return fromTime;
	}

	public void setFromTime(LocalTime fromTime) {
		this.fromTime = fromTime;
	}

	public LocalTime getToTime() {
		return toTime;
	}

	public void setToTime(LocalTime toTime) {
		this.toTime = toTime;
	}

	public String getShopTypeName() {
		return shopTypeName;
	}

	public void setShopTypeName(String shopTypeName) {
		this.shopTypeName = shopTypeName;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Float getServiceAmount() {
		return serviceAmount;
	}

	public void setServiceAmount(Float serviceAmount) {
		this.serviceAmount = serviceAmount;
	}
	
	
	

}
