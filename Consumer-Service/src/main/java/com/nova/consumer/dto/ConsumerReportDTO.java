package com.nova.consumer.dto;

import java.util.List;

public class ConsumerReportDTO {

	
	private String consumerEmail;
	
	private String consumerAddress;
	
	private String consumerGender;
	
	private Long consumerId;
	
	private String consumerName;
	
	private String phone;
	
	private String shopName;
	
	private String shopAddress;
	
	private String shopPhone;
	
	private Long shopType;
	
	private String shopLongitude;
	
	private String shopLatitude;
	
	private String appointmentType;
	
	private Long appointmentId;
	
	private String appointmentStatus;
	
	private String appointmentTime;
	
	private List<ConsumerServiceDTO> serviceList;
	
	public ConsumerReportDTO() {
		super();
	}

	public ConsumerReportDTO(String consumerEmail, String consumerAddress, String consumerGender, Long consumerId,
			String consumerName, String phone, String shopName, String shopAddress, String shopPhone, Long shopType,
			String shopLongitude, String shopLatitude, String appointmentType, Long appointmentId,
			String appointmentStatus, String appointmentTime, List<ConsumerServiceDTO> serviceList) {
		super();
		this.consumerEmail = consumerEmail;
		this.consumerAddress = consumerAddress;
		this.consumerGender = consumerGender;
		this.consumerId = consumerId;
		this.consumerName = consumerName;
		this.phone = phone;
		this.shopName = shopName;
		this.shopAddress = shopAddress;
		this.shopPhone = shopPhone;
		this.shopType = shopType;
		this.shopLongitude = shopLongitude;
		this.shopLatitude = shopLatitude;
		this.appointmentType = appointmentType;
		this.appointmentId = appointmentId;
		this.appointmentStatus = appointmentStatus;
		this.appointmentTime = appointmentTime;
		this.serviceList = serviceList;
	}

	public String getConsumerEmail() {
		return consumerEmail;
	}

	public void setConsumerEmail(String consumerEmail) {
		this.consumerEmail = consumerEmail;
	}

	public String getConsumerAddress() {
		return consumerAddress;
	}

	public void setConsumerAddress(String consumerAddress) {
		this.consumerAddress = consumerAddress;
	}

	public String getConsumerGender() {
		return consumerGender;
	}

	public void setConsumerGender(String consumerGender) {
		this.consumerGender = consumerGender;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public Long getShopType() {
		return shopType;
	}

	public void setShopType(Long shopType) {
		this.shopType = shopType;
	}

	public String getShopLongitude() {
		return shopLongitude;
	}

	public void setShopLongitude(String shopLongitude) {
		this.shopLongitude = shopLongitude;
	}

	public String getShopLatitude() {
		return shopLatitude;
	}

	public void setShopLatitude(String shopLatitude) {
		this.shopLatitude = shopLatitude;
	}

	public String getAppointmentType() {
		return appointmentType;
	}

	public void setAppointmentType(String appointmentType) {
		this.appointmentType = appointmentType;
	}

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

	public String getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public List<ConsumerServiceDTO> getServiceList() {
		return serviceList;
	}

	public void setServiceList(List<ConsumerServiceDTO> serviceList) {
		this.serviceList = serviceList;
	}
	
}
