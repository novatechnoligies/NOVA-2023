package com.nova.dataservice.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.nova.dataservice.entity.PunchInAndPunchOut;
import com.nova.dataservice.entity.ShopDetails;

public interface PunchInAndPunchOutService  {

	PunchInAndPunchOut SavePunchIn(PunchInAndPunchOut punchIn);

	Optional<PunchInAndPunchOut> updatedById(Long id);

	PunchInAndPunchOut updatedPunchOutByEmployeeIdAndDate(Long employeeId, LocalDate date);

}
