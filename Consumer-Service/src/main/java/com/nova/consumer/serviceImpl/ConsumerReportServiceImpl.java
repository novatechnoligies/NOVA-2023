package com.nova.consumer.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.nova.consumer.dao.ConsumerReportDao;
import com.nova.consumer.dto.ConsumerAppoinemtDTO;
import com.nova.consumer.dto.ConsumerReportDTO;
import com.nova.consumer.dto.ServiceDetailDTO;
import com.nova.consumer.service.ConsumerReportService;


@Service
public class ConsumerReportServiceImpl implements ConsumerReportService{
	
	@Autowired
	ConsumerReportDao consumerReportDao; 

	@Override
	public ConsumerReportDTO getConsumerReportDetails(Long conId, Long appId) throws JsonMappingException, JsonProcessingException {
		// TODO Auto-generated method stub
		return consumerReportDao.getConsumerReportDetails(conId, appId);
	}

	@Override
	public List<ServiceDetailDTO> getServiceDetailsByServiceName(String serviceName) {
		// TODO Auto-generated method stub
		return consumerReportDao.getServiceDetailsByServiceName(serviceName);
	}

	@Override
	public List<ServiceDetailDTO> findAllServicesByShopName(String shopName) {
		// TODO Auto-generated method stub
		return consumerReportDao.findAllServicesByShopName(shopName);
	}

	@Override
	public List<ConsumerAppoinemtDTO> getConsumerAppontmentDetails(LocalDate fromDate, LocalDate toDate) {
		return consumerReportDao.getConsumerAppontmentDetails(fromDate, toDate);
	}

}
