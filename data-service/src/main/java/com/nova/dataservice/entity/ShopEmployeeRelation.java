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
public class ShopEmployeeRelation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "shop_details")
	@JsonIgnore
    private ShopDetails shopId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "emp_id")
	@JsonIgnore
	private UserDetails empId;
	
	@Column(name="employee_start_date")
	private LocalDate employeeStartDate;
	
	@Column(name="employement_end_date")
	private LocalDate employementEndDate;
	
	@Column(name="reason_for_releving")
	private String reasonForReleving;
	
	@Column(name="status")
	private Boolean status;

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
