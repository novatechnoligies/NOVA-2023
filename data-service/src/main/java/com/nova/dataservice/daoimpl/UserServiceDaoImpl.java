package com.nova.dataservice.daoimpl;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nova.dataservice.DTO.ServiceDetailDTO;
import com.nova.dataservice.DTO.SlotAvailabilityDTO;
import com.nova.dataservice.dao.UserServiceDao;
import com.nova.dataservice.entity.ServiceMasterShopRelation;
import com.nova.dataservice.entity.UserDetails;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

@Repository
public class UserServiceDaoImpl implements UserServiceDao{

	@Autowired
	EntityManager entityManager;

	@Override
	public Optional<UserDetails> findByUsernameAndPassword(String userName, String password) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM user_details where username = :userName AND password = :password";

	    Query query = entityManager.createNativeQuery(sql, UserDetails.class)
	            .setParameter("userName", userName)
	            .setParameter("password", password);

	    try {
	        UserDetails userDetails = (UserDetails) query.getSingleResult();
	        return Optional.of(userDetails);
	    } catch (NoResultException e) {
	        // Handle the case where no result is found
	        return Optional.empty();
	    }
	}

	@Override
	public List<ServiceDetailDTO> findAllShopServiceByLab(Long labId, String service) {
		String sql = "select sd.shop_name as shopName,ssr.amount as amount, ssr.shop_id as shopId, ssr.service_id as serviceId, sm.name as serviceName from service_master as sm"
				+ " join shop_service_relation as ssr on ssr.service_id=sm.id"
				+ " join shop_details as sd on sd.id=ssr.shop_id"
				+ " where sm.name LIKE :serviceName and sd.id = :labId ";
		
		Query query = entityManager.createNativeQuery(sql.toString())
				.setParameter("serviceName", "%" + service + "%")
				.setParameter("labId",  labId ); 
		
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
	public List<SlotAvailabilityDTO> getAllSlotAvailabilityByLabIdAndDate(LocalDate date, Long labId) {
		String sql = "SELECT sa.id as id,sa.app_date as appDate, sa.appointment_status AS appStatus, sa.slot_time AS slot,sa.shop_id AS shopId "
				+ " FROM slot_availibility AS sa "
				+ " where shop_id = :labId and app_date = :date and sa.appointment_status = :appStatus";
		
		Query query = entityManager.createNativeQuery(sql.toString())
				.setParameter("labId", labId)
				.setParameter("date",  date )
				.setParameter("appStatus",  "OPEN" ); 
		
		query.unwrap(NativeQuery.class)
		.addScalar("id",StandardBasicTypes.LONG)
        .addScalar("appDate", StandardBasicTypes.LOCAL_DATE)
        .addScalar("appStatus", StandardBasicTypes.STRING)
        .addScalar("slot", StandardBasicTypes.LOCAL_TIME)
        .addScalar("shopId", StandardBasicTypes.LONG);
		
        ((NativeQuery) query).setResultTransformer(Transformers.aliasToBean(SlotAvailabilityDTO.class));
        
        Object result = query.getResultList();
        
        if (result != null) {
			return(List<SlotAvailabilityDTO>)result;
		}else {
			return null;
		}
	
	}

	@Override
	public List<ServiceDetailDTO> findAllShopServiceByLab(Long labId) {
		String sql = "select sd.shop_name as shopName,ssr.amount as amount, ssr.shop_id as shopId, ssr.service_id as serviceId, sm.name as serviceName,sm.description AS testDescription from service_master as sm"
				+ " join shop_service_relation as ssr on ssr.service_id=sm.id"
				+ " join shop_details as sd on sd.id=ssr.shop_id"
				+ " where sd.id = :labId ";
		
		Query query = entityManager.createNativeQuery(sql.toString())
				.setParameter("labId",  labId ); 
		
		query.unwrap(NativeQuery.class)
		.addScalar("shopName",StandardBasicTypes.STRING)
        .addScalar("amount", StandardBasicTypes.FLOAT)
        .addScalar("shopId", StandardBasicTypes.LONG)
        .addScalar("serviceId", StandardBasicTypes.LONG)
        .addScalar("serviceName", StandardBasicTypes.STRING)
        .addScalar("testDescription", StandardBasicTypes.STRING);
		
        ((NativeQuery) query).setResultTransformer(Transformers.aliasToBean(ServiceDetailDTO.class));
        
        Object result = query.getResultList();
        
        if (result != null) {
			return(List<ServiceDetailDTO>)result;
		}else {
			return null;
		}
	
	}
	
}
