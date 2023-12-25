package com.nova.demo.reportService;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nova.demo.DTO.ReportFormatDTO;
import com.nova.demo.entity.Report;

@Service
public interface ReportService {

	 Report saveReport(Report report); 

	List<ReportFormatDTO> getParametersByTestId(Long ssrId,Long labId);

}
