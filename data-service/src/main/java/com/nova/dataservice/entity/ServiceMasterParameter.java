package com.nova.dataservice.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="service_master_parameter")

public class ServiceMasterParameter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="id")
	private Long id;
	
//	@OneToMany(mappedBy = "service_master_id")
//	@JsonIgnore
//	@Column(name="service_master_id")
//	private ServiceMaster service_master_id;
	
	@Column(name="min_value")
	private String minValue;
	
	@Column(name="max_valaue")
	private String maxVlaue;
	
	@Column(name="unit")
	private String unit;
	
	@Column(name="status")
	private Boolean status;
	
	@Column(name="is_deleted")
	private Boolean isDeleted;
	
	@Column(name="is_created")
	private LocalDate isCreated;
	
	@Column(name="parameter_name")
	private String parameterName;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="has_sub_parameter")
	private Boolean hasSubParameter;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public ServiceMaster getService_master_id() {
//		return service_master_id;
//	}
//
//	public void setService_master_id(ServiceMaster service_master_id) {
//		this.service_master_id = service_master_id;
//	}

	public String getMinValue() {
		return minValue;
	}

	public void setMinValue(String minValue) {
		this.minValue = minValue;
	}

	public String getMaxVlaue() {
		return maxVlaue;
	}

	public void setMaxVlaue(String maxVlaue) {
		this.maxVlaue = maxVlaue;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
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

	public LocalDate getIsCreated() {
		return isCreated;
	}

	public void setIsCreated(LocalDate isCreated) {
		this.isCreated = isCreated;
	}

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Boolean getHasSubParameter() {
		return hasSubParameter;
	}

	public void setHasSubParameter(Boolean hasSubParameter) {
		this.hasSubParameter = hasSubParameter;
	}
	
}
