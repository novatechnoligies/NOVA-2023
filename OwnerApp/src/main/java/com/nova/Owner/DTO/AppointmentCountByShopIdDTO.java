package com.nova.Owner.DTO;

public class AppointmentCountByShopIdDTO {
	
	
	private Long id;
	
	private Long shopTotalAppointmentCount;
	
	
	
	private String AppointmentStatus;
	
	private Long slotId;
	
	private Long userId;
	
	private Float price;
	
	private Boolean appStatus;
	
	private Boolean consumerId;
	
	private Boolean serviceId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAppointmentStatus() {
		return AppointmentStatus;
	}

	public void setAppointmentStatus(String appointmentStatus) {
		AppointmentStatus = appointmentStatus;
	}

	public Long getSlotId() {
		return slotId;
	}

	public void setSlotId(Long slotId) {
		this.slotId = slotId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Boolean getAppStatus() {
		return appStatus;
	}

	public void setAppStatus(Boolean appStatus) {
		this.appStatus = appStatus;
	}

	public Boolean getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(Boolean consumerId) {
		this.consumerId = consumerId;
	}

	public Boolean getServiceId() {
		return serviceId;
	}

	public void setServiceId(Boolean serviceId) {
		this.serviceId = serviceId;
	}

	public Long getShopTotalAppointmentCount() {
		return shopTotalAppointmentCount;
	}

	public void setShopTotalAppointmentCount(Long shopTotalAppointmentCount) {
		this.shopTotalAppointmentCount = shopTotalAppointmentCount;
	}


	}
	
	

