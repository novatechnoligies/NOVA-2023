package com.nova.dataservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nova.dataservice.entity.ServiceMaster;

@Repository
public interface ServiceMasterRepository extends JpaRepository<ServiceMaster, Long> {

	@Query("SELECT s FROM ServiceMaster s  WHERE s.name LIKE %:pattern%")
	List<ServiceMaster> findServicesByNameContaining(String pattern);
}
