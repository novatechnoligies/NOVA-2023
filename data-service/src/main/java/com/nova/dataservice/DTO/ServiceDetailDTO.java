package com.nova.dataservice.DTO;

public class ServiceDetailDTO {
	
	private String shopName;
	
	private String serviceName;
	
	private Float amount;
	
	private Long shopId;
	
	private Long serviceId;

	public ServiceDetailDTO() {
		super();
	}

	public ServiceDetailDTO(String shopName, String serviceName, Float amount, Long shopId, Long serviceId) {
		super();
		this.shopName = shopName;
		this.serviceName = serviceName;
		this.amount = amount;
		this.shopId = shopId;
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
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public Long getServiceId() {
		return serviceId;
	}

	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}

	
	
	

}
