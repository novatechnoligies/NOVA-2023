package com.nova.dataservice.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "slot_availibility")
public class SlotAvailability {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
    private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
	@JsonIgnore
	private ShopDetails shopId;
	
	@Column(name = "app_date")
	private LocalDate appDate;
	
	@Column(name="last_update")
	private LocalDate lastUpdate;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
	@JsonIgnore
	private UserDetails userDetails;
	
	@Column(name = "last_updateby")
	private Long lastUpdateBy;
	
	@Column(name = "status")
	private Boolean status;
	
	@Column(name = "is_deleted")
	private Boolean isDeleted;
	
	@Column(name = "appointment_status")
	private String appintmentStatus;
	
	@Column(name = "slot_time")
	private LocalTime slotTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ShopDetails getShopId() {
		return shopId;
	}

	public void setShopId(ShopDetails shopId) {
		this.shopId = shopId;
	}

	public LocalDate getAppDate() {
		return appDate;
	}

	public void setAppDate(LocalDate appDate) {
		this.appDate = appDate;
	}

	public LocalDate getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDate lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public Long getLastUpdateBy() {
		return lastUpdateBy;
	}

	public void setLastUpdateBy(Long lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
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

	public String getAppintmentStatus() {
		return appintmentStatus;
	}

	public void setAppintmentStatus(String appintmentStatus) {
		this.appintmentStatus = appintmentStatus;
	}

	public LocalTime getSlotTime() {
		return slotTime;
	}

	public void setSlotTime(LocalTime slotTime) {
		this.slotTime = slotTime;
	}
	
}
