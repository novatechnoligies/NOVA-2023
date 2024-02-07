package com.nova.dataservice.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.dataservice.entity.AccessPermissions;
import com.nova.dataservice.entity.AppontmentDetails;
import com.nova.dataservice.entity.UserDetails;
import com.nova.dataservice.repository.AccessPermissionsRepository;
import com.nova.dataservice.repository.UserDetailsRepository;
import com.nova.dataservice.service.AccessPermissionsService;

@Service
public class AccessPermissionsImpl implements AccessPermissionsService {

	@Autowired
	AccessPermissionsRepository accessPermissionRepo;
	
	@Autowired
	UserDetailsRepository userDetailsRepository;

	@Override
	public AccessPermissions saveAccessPermissions(AccessPermissions accessPermissions) {
		// TODO Auto-generated method stub
		List<AccessPermissions> validateOldData = accessPermissionRepo.findByEmployeeDetails(accessPermissions.getEmployeeDetails());
		if (validateOldData.isEmpty()) {
			return accessPermissionRepo.save(accessPermissions);
		} else {
			accessPermissionRepo.delete(validateOldData.get(0));
			return accessPermissionRepo.save(accessPermissions);
		}
		
	}
}
