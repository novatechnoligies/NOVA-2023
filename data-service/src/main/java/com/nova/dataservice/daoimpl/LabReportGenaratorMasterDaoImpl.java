package com.nova.dataservice.daoimpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nova.dataservice.DTO.LabMasterDTO;
import com.nova.dataservice.DTO.LabMasterHeading;
import com.nova.dataservice.DTO.LabParametersDto;
import com.nova.dataservice.DTO.ServiceDetailDTO;
import com.nova.dataservice.DTO.TrackingDTO;
import com.nova.dataservice.DTO.labReportGenaratorMasterDto;
import com.nova.dataservice.dao.LabReportGenaratorMasterDao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class LabReportGenaratorMasterDaoImpl implements LabReportGenaratorMasterDao{
	
	@Autowired
	EntityManager entityManager;
	
	

	@Override
	public LabMasterDTO labReportGenaratorMaster(Long testId) {
		StringBuffer queryStr = new StringBuffer( "SELECT sm.name AS  testName, sm.id AS testId, smp.parameter_name AS testHeading, smp.id AS testHeadingId, parent.id AS parametrId, "
				+ "parent.parameter_name AS parameterName, parent.unit AS unit, parent.min_value AS minValue, parent.max_valaue AS maxValu "
				+ "FROM service_master_parameter as smp  "
				+ "JOIN service_master as sm on sm.id=smp.service_master_id "
				+ "JOIN service_master_parameter as parent on parent.parent_parameter_id = smp.id  "
				+ "WHERE smp.service_master_id = :testId ");
		Query query = entityManager.createNativeQuery(queryStr.toString())
				.setParameter("testId",  testId ); 
		
		query.unwrap(NativeQuery.class)
		.addScalar("testName",StandardBasicTypes.STRING)
		.addScalar("testId",StandardBasicTypes.LONG)
		.addScalar("testHeading",StandardBasicTypes.STRING)
		.addScalar("testHeadingId",StandardBasicTypes.LONG)
		.addScalar("parametrId",StandardBasicTypes.LONG)
		.addScalar("parameterName",StandardBasicTypes.STRING)
		.addScalar("unit",StandardBasicTypes.STRING)
		.addScalar("minValue",StandardBasicTypes.STRING)
		.addScalar("maxValu",StandardBasicTypes.STRING);
		
		
        ((NativeQuery) query).setResultTransformer(Transformers.aliasToBean(labReportGenaratorMasterDto.class));
        
        Object result = query.getResultList();
        
        if (result != null) {
        	List<labReportGenaratorMasterDto> labReportGenaratorMasterDtoData = (List<labReportGenaratorMasterDto>)result;
        	
        	LabMasterDTO labMasterDTO = convertToLabMasterDTO(labReportGenaratorMasterDtoData);
        	return labMasterDTO;
        	//need to write logic here
		}else {
			return null;
		}
	}
	
	public LabMasterDTO convertToLabMasterDTO(List<labReportGenaratorMasterDto> labReportGenaratorMasterDtoData) {
	    LabMasterDTO labMasterDTO = new LabMasterDTO();

	    for (labReportGenaratorMasterDto labReportGenaratorMasterDto : labReportGenaratorMasterDtoData) {
	        labMasterDTO.setTestId(labReportGenaratorMasterDto.getTestId());
	        labMasterDTO.setTestName(labReportGenaratorMasterDto.getTestName());

	        if (labMasterDTO.getLabMasterHeadings() == null) {
	            labMasterDTO.setLabMasterHeadings(new ArrayList<>());
	        }

	        boolean headingExists = false;
	        for (LabMasterHeading existingHeading : labMasterDTO.getLabMasterHeadings()) {
	            if (existingHeading.getTestHeading().equals(labReportGenaratorMasterDto.getTestHeading())) {
	                headingExists = true;
	                break;
	            }
	        }

	        if (!headingExists) {
	            LabMasterHeading labMasterHeading = new LabMasterHeading();
	            labMasterHeading.setTestHeading(labReportGenaratorMasterDto.getTestHeading());
	            labMasterDTO.getLabMasterHeadings().add(labMasterHeading);
	        }

	        for (LabMasterHeading heading : labMasterDTO.getLabMasterHeadings()) {
	            if (heading.getTestHeading().equals(labReportGenaratorMasterDto.getTestHeading())) {
	                if (heading.getLabParametersDtos() == null) {
	                    heading.setLabParametersDtos(new ArrayList<>());
	                }

	                LabParametersDto labParametersDto = new LabParametersDto();
	                labParametersDto.setParametrId(labReportGenaratorMasterDto.getParametrId());
	                labParametersDto.setParameterName(labReportGenaratorMasterDto.getParameterName());
	                labParametersDto.setUnit(labReportGenaratorMasterDto.getUnit());
	                labParametersDto.setMinValue(labReportGenaratorMasterDto.getMinValue());
	                labParametersDto.setMaxValu(labReportGenaratorMasterDto.getMaxValu());

	                heading.getLabParametersDtos().add(labParametersDto);
	                break;
	            }
	        }
	    }

	    return labMasterDTO;
	}

}
