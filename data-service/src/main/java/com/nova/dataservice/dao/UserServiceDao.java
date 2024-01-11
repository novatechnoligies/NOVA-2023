package com.nova.dataservice.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.nova.dataservice.DTO.ServiceDetailDTO;
import com.nova.dataservice.DTO.ShopDetailsDTO;
import com.nova.dataservice.DTO.SlotAvailabilityDTO;
import com.nova.dataservice.entity.UserDetails;

public interface UserServiceDao {

	Optional<UserDetails> findByUsernameAndPassword(String userName, String password);

	List<ServiceDetailDTO> findAllShopServiceByLab(Long labId, String service);

	List<SlotAvailabilityDTO> getAllSlotAvailabilityByLabIdAndDate(LocalDate date, Long labId);

	List<ServiceDetailDTO> findAllShopServiceByLab(Long labId);

	List<ShopDetailsDTO> getAllLabListByOwnerId(Long ownerId);

}
