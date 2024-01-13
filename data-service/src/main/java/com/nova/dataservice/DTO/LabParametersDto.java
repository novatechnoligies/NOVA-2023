package com.nova.dataservice.DTO;

public class LabParametersDto {
	
	private Long parametrId;
	private String parameterName;
	private String unit;
	private String minValue;
	private String maxValu;
	public Long getParametrId() {
		return parametrId;
	}
	public void setParametrId(Long parametrId) {
		this.parametrId = parametrId;
	}
	public String getParameterName() {
		return parameterName;
	}
	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getMinValue() {
		return minValue;
	}
	public void setMinValue(String minValue) {
		this.minValue = minValue;
	}
	public String getMaxValu() {
		return maxValu;
	}
	public void setMaxValu(String maxValu) {
		this.maxValu = maxValu;
	}
	
	
	

}
