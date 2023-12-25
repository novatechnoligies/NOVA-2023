package com.nova.demo.dao;

import java.util.List;

import com.nova.demo.DTO.ReportFormatDTO;

public interface ReportDAO {

	List<ReportFormatDTO> findAllParams(Long ssrId, Long labId);

}
