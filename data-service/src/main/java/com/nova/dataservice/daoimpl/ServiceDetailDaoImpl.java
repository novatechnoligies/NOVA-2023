package com.nova.dataservice.daoimpl;

import java.util.List;

import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nova.dataservice.DTO.AppoinmentDTO;
import com.nova.dataservice.DTO.ServiceMasterDTO;
import com.nova.dataservice.dao.ServiceDetaildao;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class ServiceDetailDaoImpl implements ServiceDetaildao {
	
	@Autowired
	EntityManager entityManager;

	@Override
	public List<ServiceMasterDTO> findAllServicesByLabId(Long labId) {
		String sql = "SELECT sm.id AS serviceId,sm.name AS serviceName,sm.description AS serviceDiscription, "
				+ "ssr.shop_id AS labId,ssr.amount AS ServiceAmount,ssr.status As serviceStatus, "
				+ "sd.shop_name AS shopName "
				+ "FROM service_master AS sm "
				+ "JOIN shop_service_relation AS ssr ON sm.id=ssr.service_id "
				+ "JOIN shop_details AS sd ON sm.id=sd.shop_type_id "
				+ "WHERE sm.id=:labId ";
				

		Query query = entityManager.createNativeQuery(sql.toString()).setParameter("labId", labId);

		query.unwrap(NativeQuery.class).addScalar("serviceId", StandardBasicTypes.LONG)
				.addScalar("serviceName", StandardBasicTypes.STRING)
				.addScalar("serviceDiscription", StandardBasicTypes.STRING)
				.addScalar("labId", StandardBasicTypes.LONG)
				.addScalar("ServiceAmount", StandardBasicTypes.FLOAT)
				.addScalar("serviceStatus", StandardBasicTypes.STRING)
				.addScalar("shopName", StandardBasicTypes.STRING);

		((NativeQuery) query).setResultTransformer(Transformers.aliasToBean(ServiceMasterDTO.class));

		Object result = query.getResultList();

		if (result != null) {
			return (List<ServiceMasterDTO>) result;
		} else {
			return null;

	}

	}
}
