package com.nova.consumer.dao;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.nova.consumer.dto.ConsumerAppoinemtDTO;
import com.nova.consumer.dto.ConsumerReportDTO;
import com.nova.consumer.dto.ServiceDetailDTO;

public interface ConsumerReportDao {

	ConsumerReportDTO getConsumerReportDetails(Long conId, Long appId) throws JsonMappingException, JsonProcessingException;

	List<ServiceDetailDTO> getServiceDetailsByServiceName(String serviceName);

	List<ServiceDetailDTO> findAllServicesByShopName(String shopName);

	List<ConsumerAppoinemtDTO> getConsumerAppontmentDetails(LocalDate fromDate, LocalDate toDate);


}
