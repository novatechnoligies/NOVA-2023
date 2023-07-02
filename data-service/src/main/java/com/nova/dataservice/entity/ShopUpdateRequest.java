package com.nova.dataservice.entity;

import java.time.LocalDate;

import org.hibernate.annotations.ManyToAny;

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
@Table(name="")
public class ShopUpdateRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="status")
	private Boolean status;
	
	@Column(name="comment")
	private String comment;
	
	@Column(name="cretaed_at")
	private LocalDate createdAt;
	
	@Column(name="created_by")
	private LocalDate createdBy;
	
	@Column(name="is_defined")
	private Boolean isDefined;
	
	@Column(name="is_deleted")
	private Boolean isDeleted;
	
	@Column(name="last_updated")
	private LocalDate lastUpdated;
	
	@Column(name="requested_type")
	private Long requestedType;
	
	@Column(name="updated_status")
	private Long updatedSatus;
	
	@Column(name="is_verified")
	private Boolean isVerified;
	
	@Column(name="last_updated_status")
    private LocalDate lastUpdatedStatus;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "shop_id")
	@JsonIgnore
	private ShopDetails shopId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDate getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(LocalDate createdBy) {
		this.createdBy = createdBy;
	}

	public Boolean getIsDefined() {
		return isDefined;
	}

	public void setIsDefined(Boolean isDefined) {
		this.isDefined = isDefined;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public LocalDate getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(LocalDate lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public Long getRequestedType() {
		return requestedType;
	}

	public void setRequestedType(Long requestedType) {
		this.requestedType = requestedType;
	}

	public Long getUpdatedSatus() {
		return updatedSatus;
	}

	public void setUpdatedSatus(Long updatedSatus) {
		this.updatedSatus = updatedSatus;
	}

	public Boolean getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(Boolean isVerified) {
		this.isVerified = isVerified;
	}

	public LocalDate getLastUpdatedStatus() {
		return lastUpdatedStatus;
	}

	public void setLastUpdatedStatus(LocalDate lastUpdatedStatus) {
		this.lastUpdatedStatus = lastUpdatedStatus;
	}

	public ShopDetails getShopId() {
		return shopId;
	}

	public void setShopId(ShopDetails shopId) {
		this.shopId = shopId;
	}

}
