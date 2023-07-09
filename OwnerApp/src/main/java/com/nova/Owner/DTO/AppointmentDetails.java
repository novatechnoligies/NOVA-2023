package com.nova.Owner.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentDetails {
	
	private Long appointmentId;
	
	private String appointmentStatus;
	
	private String shopName;
	
	private LocalDate appointmentDate;
	
	private LocalTime appointmentTime;
	
	private String consumerName;
	
	private String phone;
	
	private String serviceName;
	
	private Float serviceAmount;

	public Long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getAppointmentStatus() {
		return appointmentStatus;
	}

	public void setAppointmentStatus(String appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
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

	public String getConsumerName() {
		return consumerName;
	}

	public void setConsumerName(String consumerName) {
		this.consumerName = consumerName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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
