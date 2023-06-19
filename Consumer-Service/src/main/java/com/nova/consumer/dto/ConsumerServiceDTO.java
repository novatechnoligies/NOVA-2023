package com.nova.consumer.dto;

public class ConsumerServiceDTO {
	
	private Long serviceId;
	
	private String serviceName;
	
	private Long serviceMasterId;
	
	private Float serviceCharge;
	
	
	
	public ConsumerServiceDTO() {
		super();
	}

	public ConsumerServiceDTO(Long serviceId, String serviceName, Long serviceMasterId, Float serviceCharge) {
		super();
		this.serviceId = serviceId;
		this.serviceName = serviceName;
		this.serviceMasterId = serviceMasterId;
		this.serviceCharge = serviceCharge;
	}

	public Long getServiceId() {
		return serviceId;
	}

	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Long getServiceMasterId() {
		return serviceMasterId;
	}

	public void setServiceMasterId(Long serviceMasterId) {
		this.serviceMasterId = serviceMasterId;
	}

	public Float getServiceCharge() {
		return serviceCharge;
	}

	public void setServiceCharge(Float serviceCharge) {
		this.serviceCharge = serviceCharge;
	}
	
	
	

}
