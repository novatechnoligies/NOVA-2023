package com.nova.dataservice.daoimpl;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nova.dataservice.DTO.AppoinmentDTO;
import com.nova.dataservice.DTO.ServiceDetailDTO;
import com.nova.dataservice.dao.AppointmentDao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class AppointmentDaoImpl implements AppointmentDao{
	
	@Autowired
	EntityManager entityManager;


	@Override
	public List<AppoinmentDTO> findTodaysAppoinmentsById(LocalDate date, Long labId, LocalDate fromDate,
			LocalDate toDate) {
		String sql = "SELECT  " + "    sa.id AS appointmentId, " + "    ud.username AS patientName, "
				+ "    ud.adhar_photo AS patientAdhar, " + "    ud.phone AS patientPhone, "
				+ "    ap.appointment_status AS appointmentStatus, " + "    MAX(sa.slot_time) AS appointmentTime, "
				+ "    MAX(sa.app_date) AS appointmentDate, " + "    MAX(sa.shop_id) AS shopId " + "FROM  "
				+ "    appointment_details AS ap  " + "JOIN  " + "    user_details AS ud ON ud.id = ap.consumer_id "
				+ "JOIN  " + "    slot_availibility AS sa ON sa.id = ap.slot_id "
				+ "    WHERE sa.shop_id = :labId and sa.app_date = :toDayDatate " + "GROUP BY  "
				+ "    sa.id, ud.username, ud.adhar_photo, ud.phone, ap.appointment_status ";

		Query query = entityManager.createNativeQuery(sql.toString()).setParameter("toDayDatate", date)
				.setParameter("labId", labId);

		query.unwrap(NativeQuery.class).addScalar("appointmentId", StandardBasicTypes.LONG)
				.addScalar("patientName", StandardBasicTypes.STRING)
				.addScalar("patientAdhar", StandardBasicTypes.STRING)
				.addScalar("patientPhone", StandardBasicTypes.STRING)
				.addScalar("appointmentStatus", StandardBasicTypes.STRING)
				.addScalar("appointmentTime", StandardBasicTypes.LOCAL_TIME)
				.addScalar("appointmentDate", StandardBasicTypes.LOCAL_DATE)
				.addScalar("shopId", StandardBasicTypes.LONG);

		((NativeQuery) query).setResultTransformer(Transformers.aliasToBean(AppoinmentDTO.class));

		Object result = query.getResultList();

		if (result != null) {
			return (List<AppoinmentDTO>) result;
		} else {
			return null;
		}

	}
	

}
