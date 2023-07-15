package com.nova.Owner.ServiceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.Owner.DTO.AppointmentCountByShopIdDTO;
import com.nova.Owner.DTO.TodayAppointmentCountDTO;
import com.nova.Owner.Dao.AppointmentCountByShopIdDAO;
import com.nova.Owner.Service.AppointmentCountByShopIdService;

@Service
public class AppointmentCountByShopIdServiceImpl implements AppointmentCountByShopIdService{
	
	@Autowired
	AppointmentCountByShopIdDAO appointmentCountByShopIdDAO;

	@Override
	public AppointmentCountByShopIdDTO AppointmentCountByShopId(Long appointmentCountByShopId) {
		// TODO Auto-generated method stub
		return appointmentCountByShopIdDAO.AppointmentCountByShopId(appointmentCountByShopId);
	}

	@Override
	public TodayAppointmentCountDTO todayAppointmentCount(Long shopid, LocalDate todayDate) {
		// TODO Auto-generated method stub
		return appointmentCountByShopIdDAO.todayAppointmentCountForShop(shopid,todayDate);
	}

	@Override
	public TodayAppointmentCountDTO getAppointmentCountForShopBetweenTwoDates(Long shopId, LocalDate fromDate,
			LocalDate toDate) {
		// TODO Auto-generated method stub
		return appointmentCountByShopIdDAO.getAppointmentCountForShopBetweenTwoDates(shopId,fromDate,toDate);
	}

	

}
