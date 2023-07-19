package com.nova.Owner.DTO;


public class ServiceMasterParameterDTO {
	
	private Long id;
	private String Name;
	private Long serviceMasterId;
	private String minValue;
	private String maxiValue;
	private String ServiceMasterParameterUnit;
	private String parameterName;
	private String gender;
	private String masterParameterSubParametercol;
	private String minumumValue;
	private String maximumvalue;
	private String MasterParameterSubParameterUnit;
	private Boolean status;
	private Long parameterId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Long getServiceMasterId() {
		return serviceMasterId;
	}
	public void setServiceMasterId(Long serviceMasterId) {
		this.serviceMasterId = serviceMasterId;
	}
	public String getMinValue() {
		return minValue;
	}
	public void setMinValue(String minValue) {
		this.minValue = minValue;
	}
	public String getMaxiValue() {
		return maxiValue;
	}
	public void setMaxiValue(String maxiValue) {
		this.maxiValue = maxiValue;
	}
	public String getServiceMasterParameterUnit() {
		return ServiceMasterParameterUnit;
	}
	public void setServiceMasterParameterUnit(String serviceMasterParameterUnit) {
		ServiceMasterParameterUnit = serviceMasterParameterUnit;
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
	public String getMasterParameterSubParametercol() {
		return masterParameterSubParametercol;
	}
	public void setMasterParameterSubParametercol(String masterParameterSubParametercol) {
		this.masterParameterSubParametercol = masterParameterSubParametercol;
	}
	public String getMinumumValue() {
		return minumumValue;
	}
	public void setMinumumValue(String minumumValue) {
		this.minumumValue = minumumValue;
	}
	public String getMaximumvalue() {
		return maximumvalue;
	}
	public void setMaximumvalue(String maximumvalue) {
		this.maximumvalue = maximumvalue;
	}
	public String getMasterParameterSubParameterUnit() {
		return MasterParameterSubParameterUnit;
	}
	public void setMasterParameterSubParameterUnit(String masterParameterSubParameterUnit) {
		MasterParameterSubParameterUnit = masterParameterSubParameterUnit;
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