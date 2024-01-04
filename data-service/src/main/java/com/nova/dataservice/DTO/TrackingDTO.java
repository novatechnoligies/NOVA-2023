package com.nova.dataservice.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class TrackingDTO {

	private Long ownerId;
	private Long shopId;
	private String employeName;
	private String employePhone;
	private String ownerEmail;
	private Long empId;
	private Long userId;
	private String ownerName;
	private String shopName;
	private Double currentSalary;
	private String employePhoto;
	private String shopPhoto;
	private String shopEmail;
	
	public Long getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}
	public Long getShopId() {
		return shopId;
	}
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
	public String getEmployeName() {
		return employeName;
	}
	public void setEmployeName(String employeName) {
		this.employeName = employeName;
	}
	public String getEmployePhone() {
		return employePhone;
	}
	public void setEmployePhone(String employePhone) {
		this.employePhone = employePhone;
	}
	public String getOwnerEmail() {
		return ownerEmail;
	}
	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public Double getCurrentSalary() {
		return currentSalary;
	}
	public void setCurrentSalary(Double currentSalary) {
		this.currentSalary = currentSalary;
	}
	public String getEmployePhoto() {
		return employePhoto;
	}
	public void setEmployePhoto(String employePhoto) {
		this.employePhoto = employePhoto;
	}
	public String getShopPhoto() {
		return shopPhoto;
	}
	public void setShopPhoto(String shopPhoto) {
		this.shopPhoto = shopPhoto;
	}
	public String getShopEmail() {
		return shopEmail;
	}
	public void setShopEmail(String shopEmail) {
		this.shopEmail = shopEmail;
	}
}
