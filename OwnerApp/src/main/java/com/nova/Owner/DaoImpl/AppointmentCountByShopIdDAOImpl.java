package com.nova.Owner.DaoImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nova.Owner.DTO.AppointmentCountByShopIdDTO;
import com.nova.Owner.DTO.AppointmentDetails;
import com.nova.Owner.DTO.TodayAppointmentCountDTO;
import com.nova.Owner.Dao.AppointmentCountByShopIdDAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class AppointmentCountByShopIdDAOImpl implements AppointmentCountByShopIdDAO {
	
	@Autowired
    private EntityManager entityManager;
	
	@Override
	public AppointmentCountByShopIdDTO AppointmentCountByShopId( Long appointmentCountByShopId) {
		StringBuffer sql = new StringBuffer("SELECT count(*) AS shopTotalAppointmentCount"
				+ " FROM appointment_details As ad WHERE shop_id = :appointmentCountByShopId ");

		Query query = entityManager.createNativeQuery(sql.toString()).setParameter("appointmentCountByShopId",
				appointmentCountByShopId);

		query.unwrap(NativeQuery.class).addScalar("shopTotalAppointmentCount", StandardBasicTypes.LONG);

		((NativeQuery) query).setResultTransformer(Transformers.aliasToBean(AppointmentCountByShopIdDTO.class));

		Object result = query.getSingleResult();

		if (result != null) {
			return (AppointmentCountByShopIdDTO) result;
		} else {
			// Handle case where no result is found for the given shopId
			return null;

		}
	}


	@Override
	public TodayAppointmentCountDTO todayAppointmentCountForShop(Long shopId, LocalDate todayDate) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer("SELECT COUNT(*) AS todayAppointmentCount"
				+ " FROM appointment_details AS ad"
				+ " JOIN slot_availibility AS sl ON sl.id = ad.slot_id"
				+ " WHERE ad.shop_id =:shopId AND sl.app_date =:todayDate ");

		Query query = entityManager.createNativeQuery(sql.toString())
				.setParameter("shopId",shopId)
				.setParameter("todayDate",todayDate);

		query.unwrap(NativeQuery.class).addScalar("todayAppointmentCount", StandardBasicTypes.LONG);

		((NativeQuery) query).setResultTransformer(Transformers.aliasToBean(TodayAppointmentCountDTO.class));

		Object result = query.getSingleResult();

		if (result != null) {
			return (TodayAppointmentCountDTO) result;
		} else {
			// Handle case where no result is found for the given shopId
			return null;
		
	}
}


	@Override
	public TodayAppointmentCountDTO getAppointmentCountForShopBetweenTwoDates(Long shopId, LocalDate fromDate,
			LocalDate toDate) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer("SELECT COUNT(*) AS todayAppointmentCount"
				+ " FROM appointment_details AS ad"
				+ " JOIN slot_availibility AS sl ON sl.id = ad.slot_id"
				+ " WHERE ad.shop_id =:shopId AND sl.app_date BETWEEN :fromDate AND :toDate ");

		Query query = entityManager.createNativeQuery(sql.toString())
				.setParameter("shopId",shopId)
				.setParameter("fromDate",fromDate)
		        .setParameter("toDate",toDate);

		query.unwrap(NativeQuery.class).addScalar("todayAppointmentCount", StandardBasicTypes.LONG);

		((NativeQuery) query).setResultTransformer(Transformers.aliasToBean(TodayAppointmentCountDTO.class));

		Object result = query.getSingleResult();

		if (result != null) {
			return (TodayAppointmentCountDTO) result;
		} else {
			// Handle case where no result is found for the given shopId
			return null;
		
	}
}

	
}
