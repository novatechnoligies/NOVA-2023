package com.nova.dataservice.DTO;

import java.util.List;

public class LabMasterHeading {
	private String testHeading;
	private Long testHeadingId;
	
	private List<LabParametersDto> labParametersDtos;

	public String getTestHeading() {
		return testHeading;
	}

	public void setTestHeading(String testHeading) {
		this.testHeading = testHeading;
	}

	public Long getTestHeadingId() {
		return testHeadingId;
	}

	public void setTestHeadingId(Long testHeadingId) {
		this.testHeadingId = testHeadingId;
	}

	public List<LabParametersDto> getLabParametersDtos() {
		return labParametersDtos;
	}

	public void setLabParametersDtos(List<LabParametersDto> labParametersDtos) {
		this.labParametersDtos = labParametersDtos;
	}
	

	
}
