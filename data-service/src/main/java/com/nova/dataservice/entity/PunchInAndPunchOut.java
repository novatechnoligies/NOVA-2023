package com.nova.dataservice.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "punchInAndPunchOut")
public class PunchInAndPunchOut {
	
	private Long id;
	
	private Long employeeId;
	
	private Long shopId;
	
	private LocalDate createdAt;
	
	private LocalTime loginTime;
	
	private LocalTime logoutTime;
	
	private String status;
	
	private LocalDate updatedAt;
	
	private Long updatedBy;
	
	private Boolean isdeleted;

	private LocalDate date;
	/**
	 * @return the id
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the employeeId
	 */
	@Column(name = "employee_id")
	public Long getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the shopId
	 */
	@Column(name = "shop_id")
	public Long getShopId() {
		return shopId;
	}

	/**
	 * @param shopId the shopId to set
	 */
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	/**
	 * @return the createdAt
	 */
	@Column(name = "created_at")
	public LocalDate getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the loginTime
	 */
	@Column(name = "login_time")
	public LocalTime getLoginTime() {
		return loginTime;
	}

	/**
	 * @param loginTime the loginTime to set
	 */
	public void setLoginTime(LocalTime loginTime) {
		this.loginTime = loginTime;
	}

	/**
	 * @return the logoutTime
	 */
	@Column(name = "logout_time")
	public LocalTime getLogoutTime() {
		return logoutTime;
	}

	/**
	 * @param logoutTime the logoutTime to set
	 */
	public void setLogoutTime(LocalTime logoutTime) {
		this.logoutTime = logoutTime;
	}

	/**
	 * @return the status
	 */
	@Column(name = "status")
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the updatedAt
	 */
	@Column(name = "updated_at")
	public LocalDate getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(LocalDate updatedAt) {
		this.updatedAt = updatedAt;
	}

	/**
	 * @return the updatedBy
	 */
	@Column(name = "updated_by")
	public Long getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * @return the isdeleted
	 */
	@Column(name = "isdeleted")
	public Boolean getIsdeleted() {
		return isdeleted;
	}

	/**
	 * @param isdeleted the isdeleted to set
	 */
	public void setIsdeleted(Boolean isdeleted) {
		this.isdeleted = isdeleted;
	}
	@Column(name = "date")
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
	

}
