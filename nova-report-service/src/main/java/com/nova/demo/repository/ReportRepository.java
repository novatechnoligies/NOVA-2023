package com.nova.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nova.demo.entity.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long>{

	

}
