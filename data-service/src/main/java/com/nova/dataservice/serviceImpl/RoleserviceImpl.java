package com.nova.dataservice.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.dataservice.entity.Role;
import com.nova.dataservice.repository.RoleRepo;
import com.nova.dataservice.service.RoleService;
@Service
public class RoleserviceImpl implements RoleService {

	@Autowired
	RoleRepo repo;
	
	@Override
	public Role saveRole(Role rl) {
		// TODO Auto-generated method stub
		return repo.save(rl);
	}

	@Override
	public List<Role> getAllRole() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<Role> findRoleById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

}
