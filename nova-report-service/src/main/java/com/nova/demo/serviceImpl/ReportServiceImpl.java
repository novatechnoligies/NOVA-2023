package com.nova.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.nova.demo.DTO.ReportFormatDTO;
import com.nova.demo.dao.ReportDAO;
import com.nova.demo.entity.Report;
import com.nova.demo.reportService.ReportService;
import com.nova.demo.repository.ReportRepository;

@Service
public class ReportServiceImpl implements ReportService {
	
	
	@Autowired
	ReportDAO reportDAO;
	
	@Autowired
	ReportRepository reportRepository;
	

	@Override
	public List<ReportFormatDTO> getParametersByTestId(Long ssrId, Long labId) {
		List<ReportFormatDTO> list = reportDAO.findAllParams(ssrId,labId);
		return list;
	}

	@Override
	public Report saveReport(Report report) {
		// TODO Auto-generated method stub
		return reportRepository.save(report);
	}

}
