package com.nova.dataservice.dao;

import java.util.List;
import java.util.Optional;

import com.nova.dataservice.DTO.ServiceDetailDTO;
import com.nova.dataservice.entity.UserDetails;

public interface UserServiceDao {

	Optional<UserDetails> findByUsernameAndPassword(String userName, String password);

	List<ServiceDetailDTO> findAllShopServiceByLab(Long labId, String service);

}
