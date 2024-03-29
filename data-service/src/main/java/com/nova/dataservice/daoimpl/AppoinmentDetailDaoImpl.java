package com.nova.dataservice.daoimpl;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nova.dataservice.DTO.AppoinmentDetailDTO;
import com.nova.dataservice.DTO.EachLabEariningByOwnerIdDTO;
import com.nova.dataservice.DTO.EarningDetailsDTO;
import com.nova.dataservice.dao.AgeCategoryAppointmentCountDTO;
import com.nova.dataservice.dao.AppointmentDetailDAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class AppoinmentDetailDaoImpl implements AppointmentDetailDAO{

	@Autowired
	EntityManager entityManager;

	@Override
	public List<AppoinmentDetailDTO> findAllServicesByAppointmentIdAndPatientId(Long appointmentId, Long patientId) {
		String sql = "SELECT sa.id AS appointmentId,  ud.username AS patientName, ud.adhar_photo AS patientAdhar,  ud.phone AS patientPhone, "
				+ " ap.appointment_status AS appointmentStatus,  ap.consumer_id As patientId, ap.amount As Ammount,ap.tax1 AS tax, "
				+ " sm.id As serviceId, sm.name As serviceName, ssr.amount As serviceAmount,ssr.status As serviceStatus, sa.slot_time AS appointmentTime, "
				+ "	sa.app_date AS appointmentDate, sa.shop_id AS shopId " + "	FROM  appointment_details AS ap  "
				+ "	JOIN user_details AS ud ON ud.id = ap.consumer_id "
				+ "	JOIN   slot_availibility AS sa ON sa.id = ap.slot_id "
				+ "	JOIN service_master As sm ON sm.id = ap.service_id "
				+ "	JOIN shop_service_relation AS ssr ON ssr.id=ap.shop_id " 
				+ "	WHERE sa.id = :appointmentId";

		Query query = entityManager.createNativeQuery(sql.toString())
				.setParameter("appointmentId", appointmentId);

		query.unwrap(NativeQuery.class).addScalar("appointmentId", StandardBasicTypes.LONG)
				.addScalar("patientName", StandardBasicTypes.STRING)
				.addScalar("patientAdhar", StandardBasicTypes.STRING)
				.addScalar("patientPhone", StandardBasicTypes.STRING).addScalar("patientId", StandardBasicTypes.LONG)
				.addScalar("appointmentStatus", StandardBasicTypes.STRING)
				.addScalar("appointmentTime", StandardBasicTypes.LOCAL_TIME)
				.addScalar("appointmentDate", StandardBasicTypes.LOCAL_DATE)
				.addScalar("shopId", StandardBasicTypes.LONG).addScalar("Ammount", StandardBasicTypes.FLOAT)
				.addScalar("tax", StandardBasicTypes.STRING).addScalar("serviceId", StandardBasicTypes.LONG)
				.addScalar("serviceName", StandardBasicTypes.STRING)
				.addScalar("serviceAmount", StandardBasicTypes.FLOAT)
				.addScalar("serviceStatus", StandardBasicTypes.STRING);

		((NativeQuery) query).setResultTransformer(Transformers.aliasToBean(AppoinmentDetailDTO.class));

		Object result = query.getResultList();

		if (result != null) {
			return (List<AppoinmentDetailDTO>) result;
		} else {
			return null;
		}

	}

	@Override
	public List<AgeCategoryAppointmentCountDTO> getAdultAppointmentCountByLabId(Long labId) {
		String sql = "SELECT"
				+ "   CASE"
				+ "   WHEN ud.age < 18 THEN 'Child'"
				+ "   WHEN ud.age >= 18 AND ud.age <= 60 THEN 'Adult'"
				+ "   ELSE 'Extra Adult'"
				+ "   END AS ageCategory,"
				+ "   COUNT(*) AS ageCatAppointmentCount"
				+ "   FROM"
				+ "   appointment_details AS ad"
				+ "   LEFT JOIN"
				+ "   user_details AS ud ON ud.id = ad.consumer_id"
				+ "   where ad.shop_id =:labId "
				+ "   GROUP BY"
				+ "   ageCategory";

		Query query = entityManager.createNativeQuery(sql.toString())
				.setParameter("labId", labId);

		query.unwrap(NativeQuery.class).addScalar("ageCategory", StandardBasicTypes.STRING)
				.addScalar("ageCatAppointmentCount", StandardBasicTypes.LONG);

		((NativeQuery) query).setResultTransformer(Transformers.aliasToBean(AgeCategoryAppointmentCountDTO.class));

		Object result = query.getResultList();

		if (result != null) {
			return (List<AgeCategoryAppointmentCountDTO>) result;
		} else {
			return null;
		}

	}

	@Override
	public EarningDetailsDTO findEarningsByOwnerIdAndDate(Long ownerId, LocalDate fromDate,LocalDate toDate) {
		String sql = " SELECT ud.owner_id AS ownerId, "
				+ "  SUM(CASE WHEN ad.created_at BETWEEN :fromDate AND :toDate THEN ad.amount ELSE 0 END) AS totalEarnings, "
				+ "  SUM(CASE WHEN ad.created_at = CURDATE() THEN ad.amount ELSE 0 END) AS todaysEarnings "
				+ "FROM appointment_details AS ad "
				+ "JOIN shop_details AS sd ON sd.id = ad.shop_id "
				+ "JOIN user_details AS ud ON ud.id = sd.user_id "
				+ "WHERE ud.id = :ownerId  ";
		Query query = entityManager.createNativeQuery(sql.toString())
									.setParameter("ownerId", ownerId)
									.setParameter("fromDate", fromDate)
									.setParameter("toDate", toDate);
		
		query.unwrap(NativeQuery.class).addScalar("ownerId", StandardBasicTypes.LONG)
		                               .addScalar("todaysEarnings", StandardBasicTypes.FLOAT)
		                               .addScalar("totalEarnings", StandardBasicTypes.FLOAT);
		                               
		                               

		((NativeQuery) query).setResultTransformer(Transformers.aliasToBean(EarningDetailsDTO.class));
		Object result = query.getSingleResult();
		if (result != null) {
			return (EarningDetailsDTO)result;
		} else {
			return null;
		}
	}

	@Override
	public List<AppoinmentDetailDTO> findPastAppointmentsByLabIdAndPatientId(Long labId, Long patientId) {
		String sql = " SELECT ad.id AS appointmentId,ad.created_at AS appointmentDate,ad.slot_id AS appointmentSlot,ad.appointment_status AS appointmentStatus, "
				+ "sd.id AS shopId,sd.shop_name AS labName,sd.shop_address AS labAddress, "
				+ "ud.first_name AS patientName,ud.gender AS gender,ud.phone AS patientPhone "
				+ "FROM appointment_details AS ad "
				+ "JOIN shop_details AS sd ON sd.id=ad.shop_id "
				+ "JOIN user_details AS ud ON ad.consumer_id=ud.id "
				+ "WHERE sd.id= :labId AND ad.id= :patientId AND  ad.created_at < CURDATE() "
				+ "ORDER BY "
				+ "  ad.created_at DESC;"
				+ " ";
		Query query = entityManager.createNativeQuery(sql.toString())
									.setParameter("labId", labId)
									.setParameter("patientId", patientId);
		
		query.unwrap(NativeQuery.class).addScalar("appointmentId", StandardBasicTypes.LONG)
		                               .addScalar("appointmentDate", StandardBasicTypes.LOCAL_DATE)
		                               .addScalar("appointmentSlot", StandardBasicTypes.LONG)
		                               .addScalar("appointmentStatus", StandardBasicTypes.STRING)
		                               .addScalar("shopId", StandardBasicTypes.LONG)
		                               .addScalar("labName", StandardBasicTypes.STRING)
		                               .addScalar("labAddress", StandardBasicTypes.STRING)
		                               .addScalar("patientName", StandardBasicTypes.STRING)
		                               .addScalar("gender", StandardBasicTypes.STRING)
		                               .addScalar("patientPhone", StandardBasicTypes.STRING);
		                              
		((NativeQuery) query).setResultTransformer(Transformers.aliasToBean(AppoinmentDetailDTO.class));
		Object result = query.getResultList();
		if (result != null) {
			return (List<AppoinmentDetailDTO>)result;
		} else {
			return null;
		}
	}

	@Override
	public List<EachLabEariningByOwnerIdDTO>  findEachLabEariningByOwnerId(Long ownerId) {
		
		String sql = "SELECT SUM(ad.amount) AS totalAmount, sd.shop_name AS shopName, sl.app_date AS appDate " +
                "FROM appointment_details AS ad " +
                "JOIN slot_availibility AS sl ON sl.id = ad.slot_id " +
                "JOIN shop_details AS sd ON ad.shop_id = sd.id " +
                "WHERE sd.user_id = :ownerId " +
                "GROUP BY sd.shop_name, sl.app_date";

   Query query = entityManager.createNativeQuery(sql)
           .setParameter("ownerId", ownerId);

   query.unwrap(NativeQuery.class)
        .addScalar("totalAmount", StandardBasicTypes.FLOAT)
        .addScalar("shopName", StandardBasicTypes.STRING)
        .addScalar("appDate", StandardBasicTypes.LOCAL_DATE);

   ((NativeQuery) query).setResultTransformer(Transformers.aliasToBean(EachLabEariningByOwnerIdDTO.class));
   List<?> results = query.getResultList();

   if (results != null && !results.isEmpty()) {
       return (List<EachLabEariningByOwnerIdDTO>) results;
   }

   return Collections.emptyList();
	}
}
	

	

