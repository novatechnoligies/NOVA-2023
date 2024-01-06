package com.nova.dataservice.daoimpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nova.dataservice.DTO.AppoinmentDTO;
import com.nova.dataservice.DTO.AppoinmentDetailDTO;
import com.nova.dataservice.DTO.AppointmentTrackingDTO;
import com.nova.dataservice.DTO.TrackingDTO;
import com.nova.dataservice.dao.AppointmentDetailDAO;
import com.nova.dataservice.entity.UserDetails;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

@Repository
public class AppoinmentDetailDaoImpl implements AppointmentDetailDAO{

	private static final Query query = null;
	@Autowired
	EntityManager entityManager;

	@Override
	public List<AppoinmentDetailDTO> findAllServicesByAppointmentIdAndPatientId(Long appointmentId, Long patientId) {
		String sql ="SELECT " +" sa.id AS appointmentId, "
				+ "			    ud.username AS patientName, "
				+ "			    ud.adhar_photo AS patientAdhar, "
				+ "			    ud.phone AS patientPhone, "
				+ "			    ap.appointment_status AS appointmentStatus, "
				+ "			    ap.consumer_id As patientId, "
				+ "			    ap.amount As Ammount,ap.tax1 AS tax, "
				+ "			    sm.id As serviceId, sm.name As serviceName, "
				+ "			    ssr.amount As serviceAmount,ssr.status As serviceStatus, "
				+ "				sa.slot_time AS appointmentTime, "
				+ "			    sa.app_date AS appointmentDate, "
				+ "			    sa.shop_id AS shopId "
				+ "			   FROM  "
				+ "			    appointment_details AS ap  "
				+ "			JOIN  "
				+ "			    user_details AS ud ON ud.id = ap.consumer_id "
				+ "			JOIN  "
				+ "			    slot_availibility AS sa ON sa.id = ap.slot_id "
				+ "			JOIN service_master As sm ON sm.id = ap.service_id "
				+ "			JOIN shop_service_relation AS ssr ON ssr.id=ap.shop_id "
				+ "			    WHERE sa.id = :appointmentId and ud.id = :patientId";
				
			    
		Query query = entityManager.createNativeQuery(sql.toString())
				.setParameter("appointmentId", appointmentId)
				.setParameter("patientId", patientId);

		query.unwrap(NativeQuery.class).addScalar("appointmentId", StandardBasicTypes.LONG)
				.addScalar("patientName", StandardBasicTypes.STRING)
				.addScalar("patientAdhar", StandardBasicTypes.STRING)
				.addScalar("patientPhone", StandardBasicTypes.STRING)
				.addScalar("patientId", StandardBasicTypes.LONG)
				.addScalar("appointmentStatus", StandardBasicTypes.STRING)
				.addScalar("appointmentTime", StandardBasicTypes.LOCAL_TIME)
				.addScalar("appointmentDate", StandardBasicTypes.LOCAL_DATE)
				.addScalar("shopId", StandardBasicTypes.LONG)
		.addScalar("Ammount", StandardBasicTypes.FLOAT)
		.addScalar("tax", StandardBasicTypes.STRING)
		.addScalar("serviceId", StandardBasicTypes.LONG)
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
	public List<AppointmentTrackingDTO> getCurrentAppointmentByAppointmentIdPatientIdAndLabId(Long appointmentId,
			Long patientId, Long labId) {
		String sql = "SELECT *"
				+ "FROM appointment_details as ad"
				+ "JOIN user_details as ud ON ud.id = ad.id"
				+ "JOIN employee_details as ed ON ed.id = ad.id"
				+ "WHERE ad.id = appointmentId AND ed.id = patientId";

	    Query query = entityManager.createNativeQuery(sql, AppointmentTrackingDTO.class)
	            .setParameter("appointmentId", appointmentId)
	            .setParameter("patientId", patientId)
	    		.setParameter("labId", labId);

	    query.unwrap(NativeQuery.class)
		
		.addScalar("appointmentId",StandardBasicTypes.LONG)
        .addScalar("patientId", StandardBasicTypes.LONG)
        .addScalar("labId", StandardBasicTypes.LONG)
        .addScalar("AppointmentDate", StandardBasicTypes.LOCAL_DATE)
        .addScalar("AppointmentTime", StandardBasicTypes.LOCAL_TIME)
		.addScalar("testName", StandardBasicTypes.STRING)
		.addScalar("technicianName", StandardBasicTypes.STRING)
		.addScalar("technicianId", StandardBasicTypes.LONG)
		.addScalar("AppointmentStatus", StandardBasicTypes.BOOLEAN);
		
		
		((NativeQuery) query).setResultTransformer(Transformers.aliasToBean(AppointmentTrackingDTO.class));
		
		List<AppointmentTrackingDTO> result = query.getResultList();
			return result;
		
		
	}

	
}
