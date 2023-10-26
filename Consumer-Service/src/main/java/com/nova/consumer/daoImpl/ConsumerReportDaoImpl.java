package com.nova.consumer.daoImpl;


import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.LocalDateType;
import org.hibernate.type.LocalTimeType;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nova.consumer.dao.ConsumerReportDao;
import com.nova.consumer.dto.ConsumerAppoinemtDTO;
import com.nova.consumer.dto.ConsumerReportDTO;
import com.nova.consumer.dto.ServiceDetailDTO;

@Repository
public class ConsumerReportDaoImpl implements ConsumerReportDao {

	@Autowired
	EntityManager entityManager;
	
	@Override
	public ConsumerReportDTO getConsumerReportDetails(Long conId,Long appId) throws JsonMappingException, JsonProcessingException {
		 String sql = "SELECT sa.id AS slotId,sa.app_date AS appDate, sa.slot_time AS appTime,sa.status AS appStatus,sa.services AS appService, "
		 		+ "con.id AS consumerId,con.first_name AS consumerName, con.phone AS consumerPhone, con.email AS consumerEmail,con.gender AS consumerGender, "
		 		+ "sd.shop_name AS shopName,sd.phone AS shopPhone,sd.email AS shopEmail,sd.latitude AS shopLatitude,sd.longitude AS shopLongitude "
		 		+ "FROM slot_availibility AS sa "
		 		+ "JOIN user_details AS con ON con.id=sa.user_id "
		 		+ "JOIN shop_details AS sd ON sd.id=sa.shop_id "
		 		+ "JOIN user_details AS own ON own.id=sd.user_id "
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

	@Override
	public List<ServiceDetailDTO> getServiceDetailsByServiceName(String serviceName) {
		String sql = "select sd.shop_name as shopName,ssr.amount as amount, ssr.shop_id as shopId, ssr.service_id as serviceId, sm.name as serviceName from service_master as sm"
				+ " join shop_service_relation as ssr on ssr.service_id=sm.id"
				+ " join shop_details as sd on sd.id=ssr.shop_id"
				+ " where sm.name LIKE :serviceName";
		
		Query query = entityManager.createNativeQuery(sql.toString())
				.setParameter("serviceName", "%" + serviceName + "%");
		
		query.unwrap(NativeQuery.class)
		.addScalar("shopName",StandardBasicTypes.STRING)
        .addScalar("amount", StandardBasicTypes.FLOAT)
        .addScalar("shopId", StandardBasicTypes.LONG)
        .addScalar("serviceId", StandardBasicTypes.LONG)
        .addScalar("serviceName", StandardBasicTypes.STRING);
		
        ((NativeQuery) query).setResultTransformer(Transformers.aliasToBean(ServiceDetailDTO.class));
        
        Object result = query.getResultList();
        
        if (result != null) {
			return(List<ServiceDetailDTO>)result;
		}else {
			return null;
		}
	
	}

	@Override
	public List<ServiceDetailDTO> findAllServicesByShopName(String shopName) {
		String sql = "SELECT sd.shop_name AS shopName, ssr.amount AS amount, ssr.shop_id AS shopId, ssr.service_id AS serviceId, sm.name AS serviceName "
	            + "FROM service_master AS sm "
	            + "JOIN shop_service_relation AS ssr ON ssr.service_id = sm.id "
	            + "JOIN shop_details AS sd ON sd.id = ssr.shop_id "
	            + "WHERE sd.shop_name LIKE :shopName";
		
		Query query = entityManager.createNativeQuery(sql.toString())
			.setParameter("shopName", "%" + shopName + "%");
			
			query.unwrap(NativeQuery.class)
			.addScalar("shopName",StandardBasicTypes.STRING)
	        .addScalar("amount", StandardBasicTypes.FLOAT)
	        .addScalar("shopId", StandardBasicTypes.LONG)
	        .addScalar("serviceId", StandardBasicTypes.LONG)
	        .addScalar("serviceName", StandardBasicTypes.STRING);
		
			((NativeQuery) query).setResultTransformer(Transformers.aliasToBean(ServiceDetailDTO.class));
	        
	        Object result = query.getResultList();
	        
	        if (result != null) {
				return(List<ServiceDetailDTO>)result;
			}else {
				return null;
		}
	}

	@Override
	public List<ConsumerAppoinemtDTO> getConsumerAppontmentDetails(LocalDate fromDate, LocalDate toDate) {
		
		String sql = "SELECT ap.id as appointmentId, sa.app_date AS appDate,sa.slot_time AS slotTime , sa.appointment_status as appointmentStatus, "
				+ " consumer.id AS consumerId,consumer.first_name AS consumerName, "
				+ " own.id as ownerId, own.first_name AS ownerName,sa.id AS slotId,ap.appointment_status as appointmentStatus,ap.amount AS amount, "
				+ " sd.id AS shopId,sd.shop_name AS shopName, sd.shop_address AS shopAddress, consumer.phone AS consumerPhone "
				+ " FROM appointment_details AS ap "
				+ " JOIN shop_details AS sd ON sd.id=ap.shop_id "
				+ " JOIN slot_availibility AS sa ON sa.id=ap.slot_id "
				+ " JOIN user_details AS consumer ON consumer.id=ap.consumer_id "
				+ " JOIN user_details AS own ON own.id=ap.user_id" ;
//	            " WHERE sa.app_date >= :fromDate AND sa.app_date <= :toDate";
		
		Query query = entityManager.createNativeQuery(sql.toString());
//				.setParameter("fromDate", fromDate)
//				.setParameter("toDate", toDate);
		
		query.unwrap(NativeQuery.class)
		.addScalar("appointmentId",StandardBasicTypes.LONG)
        .addScalar("appDate", LocalDateType.INSTANCE)
        .addScalar("slotTime", LocalTimeType.INSTANCE)
        .addScalar("appointmentStatus", StandardBasicTypes.STRING)
        .addScalar("consumerId", StandardBasicTypes.LONG)
        .addScalar("consumerName", StandardBasicTypes.STRING)
        .addScalar("ownerId", StandardBasicTypes.LONG)
        .addScalar("ownerName", StandardBasicTypes.STRING)
        .addScalar("slotId", StandardBasicTypes.LONG)
        .addScalar("amount", StandardBasicTypes.FLOAT)
        .addScalar("shopId", StandardBasicTypes.LONG)
        .addScalar("shopName", StandardBasicTypes.STRING)
        .addScalar("shopAddress", StandardBasicTypes.STRING)
        .addScalar("consumerPhone", StandardBasicTypes.STRING);
		
		
        ((NativeQuery) query).setResultTransformer(Transformers.aliasToBean(ConsumerAppoinemtDTO.class));
        
        Object result = query.getResultList();
        
        if (result != null) {
			return(List<ConsumerAppoinemtDTO>)result;
		}else {
			return null;
		}
	}
	
	
}
