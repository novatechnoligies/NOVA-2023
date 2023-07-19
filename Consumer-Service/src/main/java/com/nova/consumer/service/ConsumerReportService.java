package com.nova.consumer.service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.nova.consumer.dto.ConsumerReportDTO;
import com.nova.consumer.dto.ServiceDetailDTO;

public interface ConsumerReportService {

	ConsumerReportDTO getConsumerReportDetails(Long conId ,Long appId) throws JsonMappingException, JsonProcessingException;

	List<ServiceDetailDTO> getServiceDetailsByServiceName(String serviceName);

	List<ServiceDetailDTO> findAllServicesByShopName(String shopName);
	

}
