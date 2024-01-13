package com.nova.dataservice.DTO;

import java.util.List;

public class LabMasterDTO {

	private Long testId;
	private String testName;
	private List<LabMasterHeading> labMasterHeadings;
	public Long getTestId() {
		return testId;
	}
	public void setTestId(Long testId) {
		this.testId = testId;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public List<LabMasterHeading> getLabMasterHeadings() {
		return labMasterHeadings;
	}
	public void setLabMasterHeadings(List<LabMasterHeading> labMasterHeadings) {
		this.labMasterHeadings = labMasterHeadings;
	}
	
	
}
