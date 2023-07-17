package com.nova.Owner.DaoImpl;

import java.util.List;

import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nova.Owner.DTO.ShopDetailsDTO;
import com.nova.Owner.DTO.ShopSummaryByDTO;
import com.nova.Owner.Dao.ShopSummaryDAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository

public class ShopSummaryDAOImpl implements ShopSummaryDAO {
	@Autowired
	private EntityManager entityManager;


	@Override
	public List<ShopSummaryByDTO> getShopSummaryById(Long shop_id) {

		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer("SELECT sd.id As shopId,sd.phone As phone,sd.shop_address As shopAddress,sd.email As email,sa.from_date As fromDate,"
				+ " sa.to_date As toDate,sa.from_time As fromTime,sa.to_time As toTime,st.type As shopTypeName ,sm.name AS serviceName,ssr.amount As serviceAmount"
				+ " FROM shop_details AS sd"
				+ " JOIN shop_avalibility As sa ON sd.id=sa.shop_id"
				+ " JOIN shop_service_relation AS ssr"
				+ " JOIN service_master As sm ON ssr.service_id=sm.id"
				+ " JOIN shop_type AS st On st.id= sd.shop_type_id"
				+ " WHERE sd.id =:shop_id");
		
		Query query = entityManager.createNativeQuery(sql.toString())
		        .setParameter("shop_id", shop_id);
	

		query.unwrap(NativeQuery.class)
        .addScalar("shopId", StandardBasicTypes.LONG)
        .addScalar("phone", StandardBasicTypes.STRING)
        .addScalar("shopAddress", StandardBasicTypes.STRING)
        .addScalar("email", StandardBasicTypes.STRING)
        .addScalar("fromDate", StandardBasicTypes.LOCAL_DATE)
		.addScalar("toDate", StandardBasicTypes.LOCAL_DATE)
        .addScalar("fromTime", StandardBasicTypes.LOCAL_TIME)
        .addScalar("toTime", StandardBasicTypes.LOCAL_TIME)
    	.addScalar("shopTypeName", StandardBasicTypes.STRING)
        .addScalar("serviceName", StandardBasicTypes.STRING)
        .addScalar("serviceAmount", StandardBasicTypes.FLOAT);      

((NativeQuery) query).setResultTransformer(Transformers.aliasToBean(ShopSummaryByDTO.class));

Object result = query.getResultList();

if (result != null) {
    return (List<ShopSummaryByDTO>) result;
} else {
    // Handle case where no result is found for the given shopId
    return null;
}

	
	}

}
