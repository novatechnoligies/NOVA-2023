package com.nova.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nova.dataservice.entity.BarCodeGenerateForLabEntity;

@Repository

public interface BarCodeGenerateForLabRepository extends JpaRepository<BarCodeGenerateForLabEntity, Long>{
	

}
