package com.nova.demo.daoimpl;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		 String sql = "select sd.id as shopId,sd.shop_name as shopName ,sd.phone as shopName,sd.shop_address as shopAddress,"
		 		+ " sd.latitude,sd.longitude as longitude,sd.status as shopStatus,sd.created_at as registeredDate,sd.is_deleted as deleted,\r\n"
		 		+ "st.code as shopType,\r\n"
		 		+ "ud.first_name as ownerName,ud.phone as ownerPhone,ud.id as ownerId\r\n"
		 		+ "from shop_details as sd \r\n"
		 		+ "join shop_type as st on st.id=sd.shop_type_id\r\n"
		 		+ "join user_details as ud on sd.user_id=ud.id\r\n"
		 		+ "where sd.shop_type_id =:shopTypeID";

		        Query query = entityManager.createNativeQuery(sql)
		        .setParameter("shopTypeID", shopTypeID);
		        
		        List<Object[]> resultList = query.getResultList();
		        
		        
		        List<ShopDetailsDTO> dtoList = new ArrayList<>();
		        
		        for(Object [] result:resultList) {
		        	ShopDetailsDTO dto = new ShopDetailsDTO();
		        	
		        	dto.setShopId(Long.valueOf(result[0].toString()));
		        	dto.setShopName(String.valueOf(result[1]));
		        	dto.setShopPhone(String.valueOf(result[2]));
		        	dto.setShopAddress(String.valueOf(result[3]));
		        	dto.setLatitude(Float.valueOf(result[4].toString()));
		        	dto.setLongitude(Float.valueOf(result[5].toString()));
		        	dto.setShopStatus(Boolean.valueOf(result[6].toString()));
//		        	if(result[7]!=null)
//			        	dto.setRegisteredDate(LocalDate.parse(result[7].toString()));
		        	if(result[8]!=null)
		        	dto.setDeleted(Boolean.valueOf(result[8].toString()));
		        	dto.setShopType(String.valueOf(result[9]));
		        	dto.setOwnerName(String.valueOf(result[10]));
		        	dto.setOwnerPhone(String.valueOf(result[11]));
		        	dto.setOwnerId(Long.valueOf(result[12].toString()));
		        	
		        	
		        	dtoList.add(dto);
		        }
				return dtoList;
			
		}

}
