package com.nova.dataservice.service;

import java.util.List;
import java.util.Optional;

import com.nova.dataservice.entity.Role;

public interface RoleService {

	Role saveRole(Role rl);

	List<Role> getAllRole();

	Optional<Role> findRoleById(Long id);

}
