package com.nova.demo.daoImpl;

import java.util.List;
import java.time.LocalDate;
import javax.management.loading.PrivateClassLoader;
import javax.persistence.EntityManager;

import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;


import com.nova.demo.DTO.ReportFormatDTO;
import com.nova.demo.dao.ReportDAO;


@Repository
public class ReportDaoImpl implements ReportDAO{
	
	@Autowired
	EntityManager entityManager;

	@Override
	public List<ReportFormatDTO> findAllParams(Long ssrId, Long labId) {
		String sql = "SELECT MIN(ssr.id) as ssrId, "
				+ " MIN(ssr.amount) as amount,"
				+ " MIN(ssr.service_id) as serviceMasterId,"
				+ " MIN(sm.name) as serviceMaster,"
				+ " MIN(smp.id) as parameterId,"
				+ " MIN(smp.gender) as gender,"
				+ " smp.parameter_name as parameterName,"
				+ " MIN(smp.unit) as ParamUnit,"
				+ " MIN(lsr.lab_id) as labId,"
				+ " MIN(lsr.female_normal_range_max) as femaleMaxRange,"
				+ " MIN(lsr.female_normal_range_min) as femaleMinRange,"
				+ " MIN(lsr.male_normal_range_max) as maleMaxRange,"
				+ " MIN(lsr.male_normal_range_min) as maleMinRange"
				+ " FROM shop_service_relation as ssr"
				+ " JOIN service_master As sm ON ssr.service_id = sm.id"
				+ " JOIN service_master_parameter AS smp ON smp.service_master_id = sm.id"
				+ " JOIN lab_specific_ranges AS lsr ON lsr.param_id = smp.id"
				+ " WHERE sm.id = :ssrId and lsr.lab_id = :labId"
				+ " GROUP BY smp.parameter_name";
		
		
		Query query = entityManager.createNativeQuery(sql)
                .setParameter("ssrId", ssrId)
                .setParameter("labId", labId);
		
				query.unwrap(NativeQuery.class)
				
				.addScalar("ssrId",StandardBasicTypes.LONG)
		        .addScalar("amount", StandardBasicTypes.FLOAT)
		        .addScalar("serviceMasterId", StandardBasicTypes.LONG)
		        .addScalar("serviceMaster", StandardBasicTypes.STRING)
		        .addScalar("parameterId", StandardBasicTypes.LONG)
				.addScalar("gender", StandardBasicTypes.STRING)
				.addScalar("parameterName", StandardBasicTypes.STRING)
				.addScalar("ParamUnit", StandardBasicTypes.STRING)
				.addScalar("labId", StandardBasicTypes.LONG)
				.addScalar("femaleMaxRange", StandardBasicTypes.DOUBLE)
				.addScalar("femaleMinRange", StandardBasicTypes.DOUBLE)
				.addScalar("maleMaxRange", StandardBasicTypes.DOUBLE)
				.addScalar("maleMinRange", StandardBasicTypes.DOUBLE);
				
				((NativeQuery) query).setResultTransformer(Transformers.aliasToBean(ReportFormatDTO.class));
				
				Object result = query.getResultList();
				
				if (result != null) {
					return(List<ReportFormatDTO>)result;
				}else {
					return null;
				}
		}
}