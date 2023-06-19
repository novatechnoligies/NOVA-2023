package com.nova.consumer.dao;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.nova.consumer.dto.ConsumerReportDTO;

public interface ConsumerReportDao {

	ConsumerReportDTO getConsumerReportDetails(Long conId, Long appId) throws JsonMappingException, JsonProcessingException;

}
