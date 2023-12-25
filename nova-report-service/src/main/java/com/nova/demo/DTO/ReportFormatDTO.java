package com.nova.demo.DTO;

public class ReportFormatDTO {

	private Long ssrId;
	private Float amount;
    private Long serviceMasterId;
    private String serviceMaster;
    private Long parameterId;
    private String gender;
    private String parameterName;
    private String paramUnit;
    private Long labId;
    private Double femaleMaxRange;
    private Double femaleMinRange;
    private Double maleMaxRange;
    private Double maleMinRange;
	public Long getSsrId() {
		return ssrId;
	}
	public void setSsrId(Long ssrId) {
		this.ssrId = ssrId;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	public Long getServiceMasterId() {
		return serviceMasterId;
	}
	public void setServiceMasterId(Long serviceMasterId) {
		this.serviceMasterId = serviceMasterId;
	}
	public String getServiceMaster() {
		return serviceMaster;
	}
	public void setServiceMaster(String serviceMaster) {
		this.serviceMaster = serviceMaster;
	}
	public Long getParameterId() {
		return parameterId;
	}
	public void setParameterId(Long parameterId) {
		this.parameterId = parameterId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getParameterName() {
		return parameterName;
	}
	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}
	public String getParamUnit() {
		return paramUnit;
	}
	public void setParamUnit(String paramUnit) {
		this.paramUnit = paramUnit;
	}
	public Long getLabId() {
		return labId;
	}
	public void setLabId(Long labId) {
		this.labId = labId;
	}
	public Double getFemaleMaxRange() {
		return femaleMaxRange;
	}
	public void setFemaleMaxRange(Double femaleMaxRange) {
		this.femaleMaxRange = femaleMaxRange;
	}
	public Double getFemaleMinRange() {
		return femaleMinRange;
	}
	public void setFemaleMinRange(Double femaleMinRange) {
		this.femaleMinRange = femaleMinRange;
	}
	public Double getMaleMaxRange() {
		return maleMaxRange;
	}
	public void setMaleMaxRange(Double maleMaxRange) {
		this.maleMaxRange = maleMaxRange;
	}
	public Double getMaleMinRange() {
		return maleMinRange;
	}
	public void setMaleMinRange(Double maleMinRange) {
		this.maleMinRange = maleMinRange;
	}
    
    
}
