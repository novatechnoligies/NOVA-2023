package com.nova.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.nova.dataservice.entity.ServiceMasterParameter;

@Service

public interface ServiceMasterParameterRepo  extends JpaRepository<ServiceMasterParameter, Long>{

}
