package com.nova.dataservice.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nova.dataservice.entity.PunchInAndPunchOut;

public interface PunchInAndPunchOutRepository extends JpaRepository<PunchInAndPunchOut, Long> {

	PunchInAndPunchOut findByEmployeeIdAndDate(Long employeeId, LocalDate date);

}
