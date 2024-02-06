package com.nova.dataservice.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "corpoprate_appointment_details")
public class CorporateAppontmentDetails {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name="slot_id")
    private Long slotId;
    
    @Column (name="shop_id")
    private Long shopId;
    
    @Column(name = "appointment_status")
    private String appointmentStatus;
    
    @Column (name="service_id")
    private Long serviceId;
    
    @Column (name="amount")
    private Float amount;
    
    @Column (name="tax1")
    private Float tax1;
    
    @Column (name="tax2")
    private Float tax2;
    
    @Column (name="gst")
    private Float gst;
    
    @Column (name="csgt")
    private Float cgst;
    
    @Column (name="sgst")
    private Float sgst;
   
    @Column (name="consumer_id")
    private Long patientId;
    
    @Column (name="created_at")
    private LocalDate createdAt;
    
    @Column (name="status")
    private Boolean status;
    
    @Column (name="refered_by_nova_user_name")
    private String referedByNovaUserName;
    
    @Column (name="refered_by_non_nova_user_name")
    private String referedByNonNovaUserName;

	public String getReferedByNovaUserName() {
		return referedByNovaUserName;
	}

	public void setReferedByNovaUserName(String referedByNovaUserName) {
		this.referedByNovaUserName = referedByNovaUserName;
	}

	public String getReferedByNonNovaUserName() {
		return referedByNonNovaUserName;
	}

	public void setReferedByNonNovaUserName(String referedByNonNovaUserName) {
		this.referedByNonNovaUserName = referedByNonNovaUserName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSlotId() {
		return slotId;
	}

	public void setSlotId(Long slotId) {
		this.slotId = slotId;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getAppointmentStatus() {
		return appointmentStatus;
	}

	public void setAppointmentStatus(String appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}

	public Long getServiceId() {
		return serviceId;
	}

	public void setServiceId(Long serviceId) {
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

	public Float getSgst() {
		return sgst;
	}

	public void setSgst(Float sgst) {
		this.sgst = sgst;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
