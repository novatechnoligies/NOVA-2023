package com.nova.demo.entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pramotions")
public class Pramotions {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Long id;
	@Column(name = "start_date")
	private LocalDate startDate;
	@Column(name = "exp_date")
	private LocalDate expDate;
	@Column(name = "status")
	private Boolean status;
	@Column(name = "is_deleyted" )
	private Boolean isDeleted;
	@Column(name = "is_used")
	private Boolean isUsed;
	@Column(name = "created_by")
	private Long createdBy;
	@Column(name = "pramotion_amount")
	private Float pramotionAmount;
	public Long getId() {
		return id;
	}
	@Id
	@Column
	public void setId(Long id) {
		this.id = id;
	}
	@Column
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	@Column
	public LocalDate getExpDate() {
		return expDate;
	}
	public void setExpDate(LocalDate expDate) {
		this.expDate = expDate;
	}
	@Column
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	@Column
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	@Column
	public Boolean getIsUsed() {
		return isUsed;
	}
	public void setIsUsed(Boolean isUsed) {
		this.isUsed = isUsed;
	}
	@Column
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	@Column
	public Float getPramotionAmount() {
		return pramotionAmount;
	}
	public void setPramotionAmount(Float pramotionAmount) {
		this.pramotionAmount = pramotionAmount;
	}
	
	

}

