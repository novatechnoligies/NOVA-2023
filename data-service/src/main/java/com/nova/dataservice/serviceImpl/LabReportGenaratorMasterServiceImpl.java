package com.nova.dataservice.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nova.dataservice.DTO.LabMasterDTO;
import com.nova.dataservice.dao.LabReportGenaratorMasterDao;
import com.nova.dataservice.service.LabReportGenaratorMasterService;

@Service
public class LabReportGenaratorMasterServiceImpl implements LabReportGenaratorMasterService{

	@Autowired
	LabReportGenaratorMasterDao labReportGenaratorMasterDao;

	@Override
	public LabMasterDTO labReportGenaratorMaster(Long testId) {
		return labReportGenaratorMasterDao.labReportGenaratorMaster(testId);
	}
}
