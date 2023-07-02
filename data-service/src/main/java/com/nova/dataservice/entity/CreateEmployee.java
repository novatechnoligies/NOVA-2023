package com.nova.dataservice.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "create_employee")
public class CreateEmployee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column (name="shop_id")
	private Boolean ShopId;
	@Column (name="start_date")
	private LocalDate startDate;
	@Column (name="end_date")
	private LocalDate endDtae;
	@Column (name="log_in")
	private Boolean logIn;
	@Column (name="log_out_time")
	private LocalTime logOutTime;
	@Column (name="user_id")
	private Boolean userId;
	@Column (name="emp_code")
	private String empCode;
	@Column (name="status")
	private Boolean status;
	@Column (name="is_deleted")
	private Boolean isDeleted;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Boolean getShopId() {
		return ShopId;
	}
	public void setShopId(Boolean shopId) {
		ShopId = shopId;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDtae() {
		return endDtae;
	}
	public void setEndDtae(LocalDate endDtae) {
		this.endDtae = endDtae;
	}
	public Boolean getLogIn() {
		return logIn;
	}
	public void setLogIn(Boolean logIn) {
		this.logIn = logIn;
	}
	public LocalTime getLogOutTime() {
		return logOutTime;
	}
	public void setLogOutTime(LocalTime logOutTime) {
		this.logOutTime = logOutTime;
	}
	public Boolean getUserId() {
		return userId;
	}
	public void setUserId(Boolean userId) {
		this.userId = userId;
	}
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	
	

}