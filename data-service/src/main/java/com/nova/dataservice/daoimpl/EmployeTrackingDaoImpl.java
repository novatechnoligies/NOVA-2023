package com.nova.dataservice.daoimpl;

import java.util.List;

import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nova.dataservice.DTO.TrackingDTO;
import com.nova.dataservice.dao.EmployeTrackingDao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class EmployeTrackingDaoImpl implements EmployeTrackingDao {

	@Autowired
	EntityManager entityManager;
	
	@Override
	public List<TrackingDTO> findAllParams(Long shopId, Long ownerId) {
		StringBuffer sb = new StringBuffer( "SELECT ed.owner_id as ownerId, ed.shop_id as shopId, ed.first_name as employeName, ed.phone as employePhone,"
				+ " ed.email as ownerEmail,ed.emp_id as empId, ed.user_id as userId,shd.shop_name as shopName,own.username as ownerName,"
				+ " ed.salary as currentSalary,shd.email as shopEmail,ed.employe_photo as employePhoto,shd.shop_photo as shopPhoto"
				+ " FROM employee_details as ed"
				+ " JOIN employe_tracking as et ON et.emp_id = ed.id"
				+ " JOIN user_details as own ON own.id = ed.id"
				+ " JOIN shop_details as shd ON shd.id= ed.shop_id"
				+ " WHERE shd.id = shopId AND own.id= ownerId");
		
		if (shopId != null || ownerId != null) {
            sb.append(" WHERE");
            if (shopId != null) {
                sb.append(" shd.id = :shopId");
            }
            if (shopId != null && ownerId != null) {
                sb.append(" AND");
            }
            if (ownerId != null) {
                sb.append(" own.id = :ownerId");
            }
        }
		
		Query query = entityManager.createNativeQuery(sb.toString());
				if (shopId != null) {
		            query.setParameter("shopId", shopId);
		        }
		        if (ownerId != null) {
		            query.setParameter("ownerId", ownerId);
		        }
				
				query.unwrap(NativeQuery.class)
				
				.addScalar("ownerId",StandardBasicTypes.LONG)
		        .addScalar("shopId", StandardBasicTypes.LONG)
		        .addScalar("employeName", StandardBasicTypes.STRING)
		        .addScalar("employePhone", StandardBasicTypes.STRING)
		        .addScalar("ownerEmail", StandardBasicTypes.STRING)
				.addScalar("empId", StandardBasicTypes.LONG)
				.addScalar("userId", StandardBasicTypes.LONG)
				.addScalar("shopName", StandardBasicTypes.STRING)
				.addScalar("ownerName", StandardBasicTypes.STRING)
				.addScalar("currentSalary", StandardBasicTypes.DOUBLE)
				.addScalar("shopEmail", StandardBasicTypes.STRING)
				.addScalar("employePhoto", StandardBasicTypes.STRING)
				.addScalar("shopPhoto", StandardBasicTypes.STRING)
				.addScalar("shopEmail", StandardBasicTypes.STRING);
				
				((NativeQuery) query).setResultTransformer(Transformers.aliasToBean(TrackingDTO.class));
				
				List<TrackingDTO> result = query.getResultList();
					return result;
				
	   }
}
