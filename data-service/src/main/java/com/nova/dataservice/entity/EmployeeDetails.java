package com.nova.dataservice.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
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
@Table(name = "employee_details")
public class EmployeeDetails 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id; 
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
	@JoinColumn (name="shop_id")
	private ShopDetails shopDetails;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
	@JoinColumn(name = "")
	private UserDetails employeeId;
	
	@Column (name="emp_code")
	private String empCode;
	
	@Column (name="status")
	private Boolean status;
	
	@Column (name="is_deleted")
	private Boolean isDeleted;
	
	
	@Column (name="join_date")
	private LocalDate joinDate;
	
	@Column (name="salary")
	private String salary;
	
	@Column (name="releving_date")
	private LocalDate relevingDate;
	
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
	@JoinColumn(name = "owner_id")
	private UserDetails ownerId;
	
	
	@Column (name="created_at")
	private LocalDateTime createdAt;
	
	@Column(name = "documents")
	private String documents;
	
	@Column(name = "employe_photo")
	private String photo;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ShopDetails getShopDetails() {
		return shopDetails;
	}

	public void setShopDetails(ShopDetails shopDetails) {
		this.shopDetails = shopDetails;
	}

	public UserDetails getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(UserDetails employeeId) {
		this.employeeId = employeeId;
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

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public LocalDate getRelevingDate() {
		return relevingDate;
	}

	public void setRelevingDate(LocalDate relevingDate) {
		this.relevingDate = relevingDate;
	}

	public UserDetails getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(UserDetails ownerId) {
		this.ownerId = ownerId;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getDocuments() {
		return documents;
	}

	public void setDocuments(String documents) {
		this.documents = documents;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

		
}