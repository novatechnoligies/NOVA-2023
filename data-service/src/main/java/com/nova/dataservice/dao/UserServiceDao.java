package com.nova.dataservice.dao;

import java.util.Optional;

import com.nova.dataservice.entity.UserDetails;

public interface UserServiceDao {

	Optional<UserDetails> findByUsernameAndPassword(String userName, String password);

}
