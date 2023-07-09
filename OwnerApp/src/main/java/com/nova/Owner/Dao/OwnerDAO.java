package com.nova.Owner.Dao;

import java.util.List;
import java.util.Optional;

import com.nova.Owner.DTO.AppointmentDetails;
import com.nova.Owner.DTO.AppointmentDetailsDTO;
import com.nova.Owner.DTO.ShopDetailsDTO;

public interface OwnerDAO {

	List<ShopDetailsDTO> GetShopDetailsByOwnerId(Long ownerId);

	List<AppointmentDetailsDTO> GetAppoinemetByShopId(Long shopid);

	List<AppointmentDetails> GetAppointmentDetailsByAppointmentId(Long appointmentId);

}
