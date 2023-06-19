package com.nova.consumer.daoImpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nova.consumer.dao.ConsumerReportDao;
import com.nova.consumer.dto.ConsumerReportDTO;

@Repository
public class ConsumerReportDaoImpl implements ConsumerReportDao {

	@Autowired
	EntityManager entityManager;
	
	@Override
	public ConsumerReportDTO getConsumerReportDetails(Long conId,Long appId) throws JsonMappingException, JsonProcessingException {
		 String sql = "SELECT sa.id AS slotId,sa.app_date AS appDate, sa.slot_time AS appTime,sa.status AS appStatus,sa.services AS appService,\r\n"
		 		+ "con.id AS consumerId,con.first_name AS consumerName, con.phone AS consumerPhone, con.email AS consumerEmail,con.gender AS consumerGender,\r\n"
		 		+ "sd.shop_name AS shopName,sd.phone AS shopPhone,sd.email AS shopEmail,sd.latitude AS shopLatitude,sd.longitude AS shopLongitude\r\n"
		 		+ "FROM slot_availibility AS sa\r\n"
		 		+ "JOIN user_details AS con ON con.id=sa.user_id\r\n"
		 		+ "JOIN shop_details AS sd ON sd.id=sa.shop_id\r\n"
		 		+ "JOIN user_details AS own ON own.id=sd.user_id\r\n"
		 		+ "where con.id =:conId AND sa.id =:appId ";

		        Query query = entityManager.createNativeQuery(sql)
		        .setParameter("conId", conId)
		        .setParameter("appId", appId);
		        
		        Optional<Object> data = Optional.ofNullable(query.getSingleResult());
		        ConsumerReportDTO appointmentDetails=null;
		        if (data.isPresent()) {
		            ObjectMapper objectMapper = new ObjectMapper();
		             appointmentDetails = objectMapper.readValue(objectMapper.writeValueAsString(data.get()), ConsumerReportDTO.class);
		            // Use appointmentDetails as needed
		            return appointmentDetails;
		        }
		        return appointmentDetails;
		        //return re
			
	}

}
