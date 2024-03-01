package com.nova.dataservice.DTO;

import java.time.LocalDate;

public class EachLabEariningByOwnerIdDTO {

	private Float totalAmount;

	private String shopName;

	private LocalDate appDate;

	public Float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public LocalDate getAppDate() {
		return appDate;
	}

	public void setAppDate(LocalDate appDate) {
		this.appDate = appDate;
	}

}
