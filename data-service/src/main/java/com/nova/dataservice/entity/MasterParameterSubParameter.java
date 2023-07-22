package com.nova.dataservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "master_parameter_sub_parameter")
public class MasterParameterSubParameter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column
	private String masterParameterSubParameterCol;
	@Column
	private Long minValue;
	@Column
	private Long maxValue;
	@Column
	private Boolean isDeleted;
	@Column
	private Boolean status;
	@Column
	private Long parameterId;
	
	public MasterParameterSubParameter() {
		super();
	}

	public MasterParameterSubParameter(Long id, String masterParameterSubParameterCol, Long minValue, Long maxValue,
			Boolean isDeleted, Boolean status, Long parameterId) {
		super();
		this.id = id;
		this.masterParameterSubParameterCol = masterParameterSubParameterCol;
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.isDeleted = isDeleted;
		this.status = status;
		this.parameterId = parameterId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMasterParameterSubParameterCol() {
		return masterParameterSubParameterCol;
	}

	public void setMasterParameterSubParameterCol(String masterParameterSubParameterCol) {
		this.masterParameterSubParameterCol = masterParameterSubParameterCol;
	}

	public Long getMinValue() {
		return minValue;
	}

	public void setMinValue(Long minValue) {
		this.minValue = minValue;
	}

	public Long getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(Long maxValue) {
		this.maxValue = maxValue;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Long getParameterId() {
		return parameterId;
	}

	public void setParameterId(Long parameterId) {
		this.parameterId = parameterId;
	}
	
	
	

}
