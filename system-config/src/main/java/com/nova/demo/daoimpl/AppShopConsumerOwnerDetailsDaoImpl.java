package com.nova.demo.daoimpl;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nova.demo.DTO.AppShopConsumerOwnerDetails;
import com.nova.demo.DTO.AppointmentCountDetails;
import com.nova.demo.DTO.ShopDetailsDTO;
import com.nova.demo.dao.AppShopConsumerOwnerDetailsDao;
import com.nova.demo.entity.ShopDetails;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class AppShopConsumerOwnerDetailsDaoImpl implements AppShopConsumerOwnerDetailsDao{
	
	@Autowired
    private EntityManager entityManager;

    @Override
    public List<AppShopConsumerOwnerDetails> getAllAppoinmentByShopIdAndDate(Long shopId, LocalDate date) {
        String sql = "SELECT sla.app_date AS appoinmentDate, sla.slot_time AS appoinmentTime, sla.id AS slotId, " +
                "sla.appointment_status AS appoinmentStatus, sd.shop_name AS shopName, sd.shop_address AS shopAddress, " +
                "sd.phone AS shopPhone, sd.latitude AS latitude, sd.longitude AS longitude, " +
                "con.id AS consumerId, con.username AS consumerName, con.phone AS consumerPhone, " +
                "own.id AS onwerId, own.username AS ownerName, own.phone AS ownerPhone " +
                "FROM slot_availibility AS sla " +
                "JOIN shop_details AS sd ON sd.id = sla.shop_id " +
                "JOIN user_details AS con ON con.id = sla.user_id " +
                "JOIN user_details AS own ON own.id = sd.user_id " +
                " WHERE sd.id = :shopId AND sla.app_date = :date ";

        Query query = entityManager.createNativeQuery(sql)
        .setParameter("shopId", shopId)
        .setParameter("date", Date.valueOf(date));
        
        List<Object[]> resultList = query.getResultList();
        
        List<AppShopConsumerOwnerDetails> appoinmentDetailsList = new ArrayList<>();

        for (Object[] result : resultList) {
            AppShopConsumerOwnerDetails details = new AppShopConsumerOwnerDetails();
            details.setAppoinmentDate(((Date) result[0]).toLocalDate());
            details.setAppoinmentTime(((Time) result[1]).toLocalTime());
            details.setSlotId((Long) result[2]);
            details.setAppoinmentStatus((String) result[3]);
            details.setShopName((String) result[4]);
            details.setShopAddress((String) result[5]);
            details.setShopPhone((String) result[6]);
            details.setLatitude((Long) result[7]);
            details.setLongitude((Long) result[8]);
            details.setConsumerId((Long) result[9]);
            details.setConsumerName((String) result[10]);
            details.setConsumerPhone((String) result[11]);
            details.setOnwerId((Long) result[12]);
            details.setOwnerName((String) result[13]);
            details.setOwnerPhone((String) result[14]);
            appoinmentDetailsList.add(details);
        }

        return appoinmentDetailsList;

        //return resultList;
    }

	@Override
	public AppointmentCountDetails getTotalAppointmentCount(Long shopId, String appoinmentStatus,
			LocalDate fromDate, LocalDate toDate) {
		 String sql = "SELECT count(*) AS totalBookedSlots\r\n"
		 		+ " FROM slot_availibility As sla\r\n"
		 		+ " where sla.shop_id =:shopId And sla.appointment_status =:appoinmentStatus And sla.app_date "
		 		+ " BETWEEN :fromDate AND :toDate ";

	        Query query = entityManager.createNativeQuery(sql)
	        .setParameter("shopId", shopId)
	        .setParameter("appoinmentStatus", appoinmentStatus)
	        .setParameter("fromDate", fromDate)
	        .setParameter("toDate", toDate);
	        
	        Optional<List> resultList = Optional.ofNullable(query.getResultList());
	        
	        AppointmentCountDetails aap = new AppointmentCountDetails();
	        aap.setTotalBookedSlots((Long)resultList.get().get(0));
	        return aap;
	        //return re
		
	}

	@Override
	public List<ShopDetailsDTO> getShopDetailsByShopTypeID(Long shopTypeID) {
		

		StringBuffer sql = new StringBuffer("SELECT sd.id AS shopId, sd.shop_name AS shopName, sd.phone AS shopPhone, sd.shop_address AS shopAddress, "
			        + "sd.latitude, sd.longitude, sd.status AS shopStatus, sd.created_at AS registeredDate, sd.is_deleted AS deleted, "
			        + "st.code AS shopType, "
			        + "ud.first_name AS ownerName, ud.phone AS ownerPhone, ud.id AS ownerId "
			        + "FROM shop_details AS sd "
			        + "JOIN shop_type AS st ON st.id = sd.shop_type_id "
			        + "JOIN user_details AS ud ON sd.user_id = ud.id "
			        + "WHERE sd.shop_type_id =:shopTypeID");

			Query query = entityManager.createNativeQuery(sql.toString())
			        .setParameter("shopTypeID", shopTypeID);

			query.unwrap(NativeQuery.class)
            .addScalar("shopId", StandardBasicTypes.LONG)
            .addScalar("shopName", StandardBasicTypes.STRING)
            .addScalar("shopPhone", StandardBasicTypes.STRING)
            .addScalar("shopAddress", StandardBasicTypes.STRING)
            .addScalar("latitude", StandardBasicTypes.FLOAT)
            .addScalar("longitude", StandardBasicTypes.FLOAT)
            .addScalar("shopStatus", StandardBasicTypes.BOOLEAN)
            .addScalar("registeredDate", StandardBasicTypes.DATE)
            .addScalar("deleted", StandardBasicTypes.BOOLEAN)
            .addScalar("shopType", StandardBasicTypes.STRING)
            .addScalar("ownerName", StandardBasicTypes.STRING)
            .addScalar("ownerPhone", StandardBasicTypes.STRING)
            .addScalar("ownerId", StandardBasicTypes.LONG);

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
	public ShopDetailsDTO getShopDetailsAndAppointmentCountsAndOwnerDetailsByShopId(Long shopId, LocalDate fromDate,
			LocalDate toDate) {
		StringBuffer sql = new StringBuffer("SELECT sd.id AS shopId, sd.shop_name AS shopName, sd.phone AS shopPhone, sd.shop_address AS shopAddress, "
			        + "sd.latitude, sd.longitude, sd.status AS shopStatus, sd.created_at AS registeredDate, sd.is_deleted AS deleted, "
			        + "st.code AS shopType, "
			        + "ud.first_name AS ownerName, ud.phone AS ownerPhone, ud.id AS ownerId "
			        + "FROM shop_details AS sd "
			        + "JOIN shop_type AS st ON st.id = sd.shop_type_id "
			        + "JOIN user_details AS ud ON sd.user_id = ud.id "
			        + "WHERE sd.id = :shopId ");

			Query query = entityManager.createNativeQuery(sql.toString())
			        .setParameter("shopId", shopId);

			query.unwrap(NativeQuery.class)
            .addScalar("shopId", StandardBasicTypes.LONG)
            .addScalar("shopName", StandardBasicTypes.STRING)
            .addScalar("shopPhone", StandardBasicTypes.STRING)
            .addScalar("shopAddress", StandardBasicTypes.STRING)
            .addScalar("latitude", StandardBasicTypes.FLOAT)
            .addScalar("longitude", StandardBasicTypes.FLOAT)
            .addScalar("shopStatus", StandardBasicTypes.BOOLEAN)
            .addScalar("registeredDate", StandardBasicTypes.DATE)
            .addScalar("deleted", StandardBasicTypes.BOOLEAN)
            .addScalar("shopType", StandardBasicTypes.STRING)
            .addScalar("ownerName", StandardBasicTypes.STRING)
            .addScalar("ownerPhone", StandardBasicTypes.STRING)
            .addScalar("ownerId", StandardBasicTypes.LONG);

			NativeQuery<?> nativeQuery = query.unwrap(NativeQuery.class);
		    nativeQuery.setResultTransformer(Transformers.aliasToBean(ShopDetailsDTO.class));

		    ShopDetailsDTO dto = (ShopDetailsDTO) nativeQuery.getSingleResult();
        return dto;
        // Handle case where no result is found for the given shopId
      //  return null;
  //  }
}

}
