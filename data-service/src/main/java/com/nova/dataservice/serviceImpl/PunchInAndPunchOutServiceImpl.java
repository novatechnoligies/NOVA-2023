package com.nova.dataservice.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nova.dataservice.entity.PunchInAndPunchOut;
import com.nova.dataservice.repository.PunchInAndPunchOutRepository;
import com.nova.dataservice.service.PunchInAndPunchOutService;

@Service
public class PunchInAndPunchOutServiceImpl implements PunchInAndPunchOutService {
 
	@Autowired
	PunchInAndPunchOutRepository punchInAndPunchOutRepo; 

	@Override
	public PunchInAndPunchOut SavePunchIn(PunchInAndPunchOut punchIn) {
		// TODO Auto-generated method stub
		return punchInAndPunchOutRepo.save(punchIn);
	}

	@Override
	public Optional<PunchInAndPunchOut> updatedById(Long id) {
		// TODO Auto-generated method stub
		return punchInAndPunchOutRepo.findById(id);
	}


	@Override
	public PunchInAndPunchOut updatedPunchOutByEmployeeIdAndDate(Long employeeId, LocalDate date) {
		// TODO Auto-generated method stub
		return punchInAndPunchOutRepo.findByEmployeeIdAndDate(employeeId, date);
	}

	}
	
	


