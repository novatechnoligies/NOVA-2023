package com.nova.consumer.dto;

import java.time.LocalDate;
import java.time.LocalTime;


public class ConsumerAppoinemtDTO {

	Long appointmentId;
	LocalDate appDate;
	LocalTime slotTime;
	String appointmentStatus;
	String consumerPhone;
	Long consumerId;
	String  consumerName;
	Long ownerId;
	String ownerName;
	Long slotId;
	Float amount;
	Long shopId;
	String shopName;
	String shopAddress;
	Float tax1;
	Float tax2;
	Float gst;
	Float cgst;
	Long serviceCount;
	public Long getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}
	public LocalTime getSlotTime() {
		return slotTime;
	}
	public void setSlotTime(LocalTime slotTime) {
		this.slotTime = slotTime;
	}
	public String getAppointmentStatus() {
		return appointmentStatus;
	}
	public void setAppointmentStatus(String appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}
	public String getConsumerPhone() {
		return consumerPhone;
	}
	public void setConsumerPhone(String consumerPhone) {
		this.consumerPhone = consumerPhone;
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
	public Long getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public Long getSlotId() {
		return slotId;
	}
	public void setSlotId(Long slotId) {
		this.slotId = slotId;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	public Long getShopId() {
		return shopId;
	}
	public void setShopId(Long shopId) {
		this.shopId = shopId;
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
	public Float getTax1() {
		return tax1;
	}
	public void setTax1(Float tax1) {
		this.tax1 = tax1;
	}
	public Float getTax2() {
		return tax2;
	}
	public void setTax2(Float tax2) {
		this.tax2 = tax2;
	}
	public Float getGst() {
		return gst;
	}
	public void setGst(Float gst) {
		this.gst = gst;
	}
	public Float getCgst() {
		return cgst;
	}
	public void setCgst(Float cgst) {
		this.cgst = cgst;
	}
	public Long getServiceCount() {
		return serviceCount;
	}
	public void setServiceCount(Long serviceCount) {
		this.serviceCount = serviceCount;
	}
	public LocalDate getAppDate() {
		return appDate;
	}
	public void setAppDate(LocalDate appDate) {
		this.appDate = appDate;
	}
}
