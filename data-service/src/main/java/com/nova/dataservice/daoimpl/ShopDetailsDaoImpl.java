package com.nova.dataservice.daoimpl;

import java.util.List;

import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.nova.dataservice.DTO.ShopDetailsDTO;
import com.nova.dataservice.DTO.ShopDetailsDashboardDTO;
import com.nova.dataservice.dao.ShopDetailsDao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class ShopDetailsDaoImpl implements ShopDetailsDao{

	@Autowired
	EntityManager entityManager;
	
	@Override
	public List<ShopDetailsDashboardDTO> findAllLabListByOwnerId1(Long ownerId) {
		String sql = "SELECT sd.id AS id,sd.email AS email,sd.gst_no AS gstNo,sd.logo AS logo,sd.phone AS phone,sd.latitude AS latitude,sd.longitude AS longitude, "
				+ "ud.id AS OwnerId, ud.username AS ownerName,ad.amount AS totalEarnings "
				+ "FROM shop_details AS sd "
				+ "JOIN user_details AS ud ON ud.id= sd.user_id "
				+ "JOIN appointment_details AS ad ON ad.shop_id=sd.id "
				+ "where sd.user_id = :ownerId";
		
		Query query = entityManager.createNativeQuery(sql.toString())
				.setParameter("ownerId",  ownerId ); 
		
		query.unwrap(NativeQuery.class)
		.addScalar("id",StandardBasicTypes.LONG)
		.addScalar("email",StandardBasicTypes.STRING)
		.addScalar("gstNo",StandardBasicTypes.STRING)
        .addScalar("logo", StandardBasicTypes.STRING)
        .addScalar("phone", StandardBasicTypes.STRING)
        .addScalar("latitude", StandardBasicTypes.STRING)
        .addScalar("longitude", StandardBasicTypes.STRING)
		.addScalar("OwnerId", StandardBasicTypes.LONG)
		.addScalar("ownerName", StandardBasicTypes.STRING)
		.addScalar("TotalEarnings", StandardBasicTypes.FLOAT);
		
		
        ((NativeQuery) query).setResultTransformer(Transformers.aliasToBean(ShopDetailsDashboardDTO.class));
        
        Object result = query.getResultList();
        
        if (result != null) {
			return(List<ShopDetailsDashboardDTO>)result;
		}else {
			return null;
		}
	
	}
}
