package com.nova.dataservice.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.dataservice.entity.AccessPermissions;
import com.nova.dataservice.entity.AppontmentDetails;
import com.nova.dataservice.repository.AccessPermissionsRepository;
import com.nova.dataservice.service.AccessPermissionsService;

@Service
public class AccessPermissionsImpl implements AccessPermissionsService {

	@Autowired
	AccessPermissionsRepository accessPermissionRepo;

	@Override
	public AccessPermissions saveAccessPermissions(AccessPermissions accessPermissions) {
		// TODO Auto-generated method stub
		return accessPermissionRepo.save(accessPermissions);
	}
}
