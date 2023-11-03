package com.nova.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nova.dataservice.entity.Locations;

public interface LocationRepository extends JpaRepository<Locations, Long> {

}
