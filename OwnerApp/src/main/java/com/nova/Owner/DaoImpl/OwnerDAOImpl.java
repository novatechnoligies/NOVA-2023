package com.nova.Owner.DaoImpl;


import java.util.List;
import java.util.Optional;

import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nova.Owner.DTO.AppointmentDetails;
import com.nova.Owner.DTO.AppointmentDetailsDTO;
import com.nova.Owner.DTO.ShopDetailsDTO;
import com.nova.Owner.Dao.OwnerDAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class OwnerDAOImpl implements OwnerDAO{
	
	@Autowired
    private EntityManager entityManager;

	@Override
	public List<ShopDetailsDTO> GetShopDetailsByOwnerId(Long ownerId) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer("SELECT sd.id As shopId,sd.shop_address As shopAddress,sd.shop_name As shopName,sd.phone As shopPhone,"
				+ " sd.logo As shopLogo "
				+ " FROM shop_details As sd "
				+ " where sd.user_id =:ownerId");
		
		Query query = entityManager.createNativeQuery(sql.toString())
		        .setParameter("ownerId", ownerId);

		query.unwrap(NativeQuery.class)
        .addScalar("shopId", StandardBasicTypes.LONG)
        .addScalar("shopAddress", StandardBasicTypes.STRING)
        .addScalar("shopName", StandardBasicTypes.STRING)
        .addScalar("shopPhone", StandardBasicTypes.STRING)
        .addScalar("shopLogo", StandardBasicTypes.STRING);
//		We Missed Below Mentioned Coloums 
//		.addScalar("NumberOfEmployees", StandardBasicTypes.STRING); 
//		.addScalar("todaysAppcont", StandardBasicTypes.STRING);
//		.addScalar("ratings", StandardBasicTypes.STRING);
//        

((NativeQuery) query).setResultTransformer(Transformers.aliasToBean(ShopDetailsDTO.class));

Object result = query.getResultList();

if (result != null) {
    return (List<ShopDetailsDTO>) result;
} else {
    // Handle case where no result is found for the given shopId
    return null;
}

	}

	@Override
	public List<AppointmentDetailsDTO> GetAppoinemetByShopId(Long shopId) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer("SELECT sl.id As slotId,sl.app_date As appointmentDate,sl.slot_time As appointmentTime,sl.appointment_status As appointmentStatus,"
				+ " ud.first_name As consumerName,ud.phone As consumerPhone,ud.adhar_photo As consumerPhoto,sd.shop_name AS shopName,own.first_name As ownerName"
				+ " FROM slot_availibility As sl"
				+ " JOIN user_details As ud ON sl.user_id=ud.id"
				+ " JOIN shop_details As sd ON sl.shop_id=sd.id"
				+ " JOIN user_details As own ON sd.user_id=own.id"
				+ " Where sl.shop_id =:shopId ");
		
		Query query = entityManager.createNativeQuery(sql.toString())
		        .setParameter("shopId", shopId);

		query.unwrap(NativeQuery.class)
        .addScalar("slotId", StandardBasicTypes.LONG)
        .addScalar("appointmentDate", StandardBasicTypes.LOCAL_DATE)
        .addScalar("appointmentTime", StandardBasicTypes.LOCAL_TIME)
        .addScalar("appointmentStatus", StandardBasicTypes.STRING)
        .addScalar("consumerName", StandardBasicTypes.STRING) 
		.addScalar("consumerPhone", StandardBasicTypes.STRING)
        .addScalar("consumerPhoto", StandardBasicTypes.STRING)
        .addScalar("shopName", StandardBasicTypes.STRING)
        .addScalar("ownerName", StandardBasicTypes.STRING);
//		we missed Colom
//		.addScalar("TypeOfAppointment", StandardBasicTypes.STRING);
		
        

((NativeQuery) query).setResultTransformer(Transformers.aliasToBean(AppointmentDetailsDTO.class));

Object result = query.getResultList();

if (result != null) {
   return (List<AppointmentDetailsDTO>)result;
} else {
    // Handle case where no result is found for the given shopId
    return null;
		
	}

}

	@Override
	public List<AppointmentDetails> GetAppointmentDetailsByAppointmentId(Long appointmentId) {
		StringBuffer sql = new StringBuffer("SELECT ad.id As appointmentId,ad.app_status As appointmentStatus,"
				+ " sd.shop_name As shopName,sl.app_date As appointmentDate,sl.slot_time As appointmentTime,"
				+ " ud.first_name As consumerName,ud.phone As phone,"
				+ " sm.name As serviceName,ssr.amount As serviceAmount "
				+ " FROM appointment_details AS ad"
				+ " JOIN shop_details As sd ON sd.id=ad.shop_id"
				+ " JOIN slot_availibility As sl ON sl.id = ad.slot_id"
				+ " JOIN user_details As ud ON ud.id = ad.user_id"
				+ " JOIN shop_service_relation As ssr ON ssr.id=ad.service_id"
				+ " JOIN service_master AS sm ON sm.id=ssr.service_id"
				+ " WHERE sl.id = :appointmentId ");
		
		Query query = entityManager.createNativeQuery(sql.toString())
		        .setParameter("appointmentId", appointmentId);

		query.unwrap(NativeQuery.class)
        .addScalar("appointmentId", StandardBasicTypes.LONG)
        .addScalar("appointmentStatus", StandardBasicTypes.STRING)
        .addScalar("shopName", StandardBasicTypes.STRING)
        .addScalar("appointmentDate", StandardBasicTypes.LOCAL_DATE)
        .addScalar("appointmentTime", StandardBasicTypes.LOCAL_TIME) 
		.addScalar("consumerName", StandardBasicTypes.STRING)
        .addScalar("phone", StandardBasicTypes.STRING)
        .addScalar("serviceName", StandardBasicTypes.STRING)
        .addScalar("serviceAmount", StandardBasicTypes.FLOAT);
//		we missed Colom
//		.addScalar("TypeOfAppointment", StandardBasicTypes.STRING);
		
        

((NativeQuery) query).setResultTransformer(Transformers.aliasToBean(AppointmentDetails.class));

Object result = query.getResultList();

if (result != null) {
   return (List<AppointmentDetails>)result;
} else {
    // Handle case where no result is found for the given shopId
    return null;
		
	}
}
}
