package com.nova.dataservice.daoimpl;


import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nova.dataservice.dao.UserServiceDao;
import com.nova.dataservice.entity.UserDetails;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

@Repository
public class UserServiceDaoImpl implements UserServiceDao{

	@Autowired
	EntityManager entityManager;

	@Override
	public Optional<UserDetails> findByUsernameAndPassword(String userName, String password) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM user_details where username = :userName AND password = :password";

	    Query query = entityManager.createNativeQuery(sql, UserDetails.class)
	            .setParameter("userName", userName)
	            .setParameter("password", password);

	    try {
	        UserDetails userDetails = (UserDetails) query.getSingleResult();
	        return Optional.of(userDetails);
	    } catch (NoResultException e) {
	        // Handle the case where no result is found
	        return Optional.empty();
	    }
	}
	
}
