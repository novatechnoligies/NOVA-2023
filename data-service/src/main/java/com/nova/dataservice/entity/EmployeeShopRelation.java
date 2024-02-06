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
@Table(name="shop_employee_relation")
public class EmployeeShopRelation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "shop_details")
    private ShopDetails shopId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "emp_id")
	private UserDetails empId;
	
	@Column(name="employee_start_date")
	private LocalDate employeeStartDate;
	
	@Column(name="employement_end_date")
	private LocalDate employementEndDate;
	
	@Column(name="reason_for_releving")
	private String reasonForReleving;
	
	@Column(name="status")
	private Boolean status;
	
	@Column(name="is_deleted")
	private Boolean isDeleted;
	
	@Column(name="salary")
	private Float salary;
	
	@Column(name="owner_id")
	private Long ownerId;
	
	@Column(name="emp_code")
	private String empCode;
	
	@Column(name="createdAt")
	private LocalDate created_at;

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public LocalDate getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDate created_at) {
		this.created_at = created_at;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ShopDetails getShopId() {
		return shopId;
	}

	public void setShopId(ShopDetails shopId) {
		this.shopId = shopId;
	}

	public UserDetails getEmpId() {
		return empId;
	}

	public void setEmpId(UserDetails empId) {
		this.empId = empId;
	}

	public LocalDate getEmployeeStartDate() {
		return employeeStartDate; 
	}

	public void setEmployeeStartDate(LocalDate employeeStartDate) {
		this.employeeStartDate = employeeStartDate;
	}

	public LocalDate getEmployementEndDate() {
		return employementEndDate;
	}

	public void setEmployementEndDate(LocalDate employementEndDate) {
		this.employementEndDate = employementEndDate;
	}

	public String getReasonForReleving() {
		return reasonForReleving;
	}

	public void setReasonForReleving(String reasonForReleving) {
		this.reasonForReleving = reasonForReleving;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	
	
	
	
	
	
}
