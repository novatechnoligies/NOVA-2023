package com.nova.demo.DTO;

import java.util.List;

public class ReportParamDetailsDTO {

	private String testName;
    private String masterId;
    private String amount;
    private List<ParamDTO> params;
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public String getMasterId() {
		return masterId;
	}
	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
    
    
}
