package com.nova.dataservice.DTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nova.dataservice.entity.Organization;
import com.nova.dataservice.entity.Role;
import com.nova.dataservice.entity.ShopDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

public class UserDetailsDTO {

	private Long id;

	private String firstName;

	private String lastName;

	private String email;

	private String phone;

	private String pin;

	private String gender;

	private LocalDate createdAt;

	private Boolean status;

	private Boolean isDeleted;

	private Long ownerId;

	private String username;

	private String password;

	private String adharNo;

	private String adharPhoto;

	private String ownerPhoto;

	private String otp;

	private Boolean isPhoneNoVerified;

	private RoleDTO role;
	
	private String age;

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

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

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
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

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public Boolean getIsPhoneNoVerified() {
		return isPhoneNoVerified;
	}

	public void setIsPhoneNoVerified(Boolean isPhoneNoVerified) {
		this.isPhoneNoVerified = isPhoneNoVerified;
	}

	public RoleDTO getRole() {
		return role;
	}

	public void setRole(RoleDTO role) {
		this.role = role;
	}

}
