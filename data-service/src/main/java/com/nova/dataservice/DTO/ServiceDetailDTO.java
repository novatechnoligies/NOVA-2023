package com.nova.dataservice.DTO;

public class ServiceDetailDTO {
	
	private String shopName;
	
	private String serviceName;
	
	private Float ServiceAmount;
	
	private Long labId;
	
	private Long serviceId;
	
	private String serviceDiscription;
	
	private String serviceStatus;

	public ServiceDetailDTO() {
		super();
	}

	public ServiceDetailDTO(String shopName, String serviceName, Float ServiceAmount, Long labId, Long serviceId) {
		super();
		this.shopName = shopName;
		this.serviceName = serviceName;
		this.ServiceAmount = ServiceAmount;
		this.labId = labId;
		this.serviceId = serviceId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Float getAmount() {
		return ServiceAmount;
	}

	public void setAmount(Float amount) {
		this.ServiceAmount = amount;
	}

	public Long getLabId() {
		return labId;
	}

	public void setLabId(Long labId) {
		this.labId = labId;
	}

	public Long getServiceId() {
		return serviceId;
	}

	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceDiscription() {
		return serviceDiscription;
	}

	public void setServiceDiscription(String serviceDiscription) {
		this.serviceDiscription = serviceDiscription;
	}

	public String getServiceStatus() {
		return serviceStatus;
	}

	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}

	
	
	

}
