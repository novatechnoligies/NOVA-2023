package com.nova.dataservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "appointment_details")
public class AppontmentDetails {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name="slot_id")
    private Boolean slotId;
    @Column (name="shop_id")
    private Boolean shopId;
    @Column (name="app_status")
    private Boolean appStatus;
    @Column(name = "appointment_status")
    private String appointmentStatus;
    @Column (name="service_id")
    private Boolean serviceId;
    @Column (name="amount")
    private Float amount;
    @Column (name="tax1")
    private Float tax1;
    @Column (name="tax2")
    private Float tax2;
    @Column (name="gst")
    private Boolean gst;
    @Column (name="csgt")
    private Boolean cgst;
   @Column (name="sgst")
   private Boolean sgst;
   @Column (name="consumer_id")
   private Boolean consumerId;
   @Column (name="created_at")
   private Boolean createdAt;
   @Column (name="status")
   private Boolean status;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Boolean getSlotId() {
		return slotId;
	}


	public void setSlotId(Boolean slotId) {
		this.slotId = slotId;
	}


	public Boolean getShopId() {
		return shopId;
	}


	public void setShopId(Boolean shopId) {
		this.shopId = shopId;
	}


	public Boolean getAppStatus() {
		return appStatus;
	}


	public void setAppStatus(Boolean appStatus) {
		this.appStatus = appStatus;
	}


	public Boolean getServiceId() {
		return serviceId;
	}


	public void setServiceId(Boolean serviceId) {
		this.serviceId = serviceId;
	}


	public Float getAmount() {
		return amount;
	}


	public void setAmount(Float amount) {
		this.amount = amount;
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


	public Boolean getGst() {
		return gst;
	}


	public void setGst(Boolean gst) {
		this.gst = gst;
	}


	public Boolean getCgst() {
		return cgst;
	}


	public void setCgst(Boolean cgst) {
		this.cgst = cgst;
	}


	public Boolean getSgst() {
		return sgst;
	}


	public void setSgst(Boolean sgst) {
		this.sgst = sgst;
	}


	public Boolean getConsumerId() {
		return consumerId;
	}


	public void setConsumerId(Boolean consumerId) {
		this.consumerId = consumerId;
	}


	public Boolean getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Boolean createdAt) {
		this.createdAt = createdAt;
	}


	public Boolean getStatus() {
		return status;
	}


	public void setStatus(Boolean status) {
		this.status = status;
	}


	public String getAppointmentStatus() {
		return appointmentStatus;
	}
    
}
