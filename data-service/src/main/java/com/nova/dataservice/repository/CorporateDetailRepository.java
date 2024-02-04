package com.nova.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nova.dataservice.entity.CorporateDetails;

@Repository

public interface CorporateDetailRepository extends JpaRepository<CorporateDetails, Long>{

}
