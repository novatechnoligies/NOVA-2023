package com.nova.dataservice.service;

import java.util.List;
import java.util.Optional;

import com.nova.dataservice.DTO.LocationsDTO;
import com.nova.dataservice.entity.Locations;

public interface LocationService {

	Locations saveLocation(Locations location);

	List<Locations> getLocation();

	LocationsDTO findLocationsByOrgId(Long id);

}
