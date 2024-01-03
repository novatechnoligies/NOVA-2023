package com.nova.dataservice.dao;

import java.util.List;

import com.nova.dataservice.DTO.TrackingDTO;

public interface EmployeTrackingDao {

	List<TrackingDTO> findAllParams(Long shopId, Long ownerId);

}
