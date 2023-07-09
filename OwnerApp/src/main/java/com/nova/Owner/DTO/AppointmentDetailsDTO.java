package com.nova.Owner.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentDetailsDTO {
	
	
	private Long slotId;
	
	private LocalDate appointmentDate;
	
	private LocalTime appointmentTime;
	
	private String appointmentStatus;
	
	private String consumerName;
	
	private String consumerPhone;
	
	private String consumerPhoto;
	
	private String shopName;
	
	private String ownerName;

	public Long getSlotId() {
		return slotId;
	}

	public void setSlotId(Long slotId) {
		this.slotId = slotId;
	}

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public LocalTime getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(LocalTime appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public String getAppointmentStatus() {
		return appointmentStatus;
	}

	public void setAppointmentStatus(String appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
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

	public String getConsumerPhoto() {
		return consumerPhoto;
	}

	public void setConsumerPhoto(String consumerPhoto) {
		this.consumerPhoto = consumerPhoto;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	

}
