package com.nova.dataservice.entity;

import java.time.LocalDate;

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
@Table(name="corporate_details")
public class CorporateDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name="employee_id")
	private  String employeeId;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="company_code")
	private String companyCode;
	
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	

	@Column(name="employee_email")
	private String employeeEmail;
	
	@Column(name = "phone")
	private String phone;

	@Column(name="employee_phone")
	private String employeePhone;
	
	@Column(name = "pin")
	private String pin;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "created_at")
	private LocalDate createdAt;
	
	@Column(name = "status")
	private Boolean status;
	
	@Column(name = "is_deleted")
	private Boolean isDeleted;
	
	@Column(name = "created_by")
	private Long createdBy;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "adhar_no")
	private String adharNo;
	
	@Column(name = "adhar_photo")
	private String adharPhoto;
	
	@Column(name = "owner_photo")
	private String ownerPhoto;
	
	@Column(name = "dob")
	private LocalDate dob;
	
	@Column(name = "age")
	private Integer age;
	
	@Column(name = "otp")
	private String otp;
	
	@Column(name = "is_phone_no_verified")
	private Boolean isPhoneNoVerified;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id")
	private Role role;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "org_id")
	private Organization organization;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	public String getAdharNo() {
		return adharNo;
	}

	public void setAdharNo(String adharNo) {
		this.adharNo = adharNo;
	}

	public String getAdharPhoto() {
		return adharPhoto;
	}

	public void setAdharPhoto(String adharPhoto) {
		this.adharPhoto = adharPhoto;
	}

	public String getOwnerPhoto() {
		return ownerPhoto;
	}

	public void setOwnerPhoto(String ownerPhoto) {
		this.ownerPhoto = ownerPhoto;
	}

	public Boolean getIsPhoneNoVerified() {
		return isPhoneNoVerified;
	}

	public void setIsPhoneNoVerified(Boolean isPhoneNoVerified) {
		this.isPhoneNoVerified = isPhoneNoVerified;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getcompanyCode() {
		return companyCode;
	}

	public void setcompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getemployeePhone() {
		return employeePhone;
	}

	public void setemployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}
	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}
	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}



}
