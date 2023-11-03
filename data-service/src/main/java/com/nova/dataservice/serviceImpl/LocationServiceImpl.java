package com.nova.dataservice.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.dataservice.DTO.LocationsDTO;
import com.nova.dataservice.DTO.UserDetailsDTO;
import com.nova.dataservice.entity.Locations;
import com.nova.dataservice.entity.Role;
import com.nova.dataservice.repository.LocationRepository;
import com.nova.dataservice.service.LocationService;

import jakarta.transaction.Transactional;

@Service
public class LocationServiceImpl implements LocationService {
	 
	@Autowired
	LocationRepository LRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Transactional
	 public Locations saveLocation(Locations location) {
		 return LRepo.save(location);
		
	}

	@Transactional
	public List<Locations> getLocation() {
		// TODO Auto-generated method stub
		return LRepo.findAll();
	}

	@Override
	public LocationsDTO findLocationsByOrgId(Long id) {
		LocationsDTO dto = modelMapper.map(LRepo.findById(id).get(), LocationsDTO.class);
		return dto;
		//return LRepo.findById(id); 
	}


}
