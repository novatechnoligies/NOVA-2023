package com.nova.dataservice.daoimpl;


import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nova.dataservice.DTO.PatientDetailsDTO;
import com.nova.dataservice.dao.PatientDetailsDao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

@SuppressWarnings("deprecation")
@Repository
public class PatientDetailsDaoImpl implements PatientDetailsDao {

    private final EntityManager entityManager;

    @Autowired
    public PatientDetailsDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public PatientDetailsDTO findPatientDetailsByAppointmentId(Long appointmentId) {
        String sql = "SELECT ap.id AS appointmentId, ap.consumer_id AS patientId, ap.created_at AS appointmentDate, "
                + "ud.adhar_photo AS profilePhoto, ud.email AS emailId, ud.gender AS gender, ud.phone AS phoneNumber, ud.pin AS zipCode "
                + " FROM  appointment_details AS ap "
                + " JOIN user_details As ud ON ud.id=ap.consumer_id "
                + " WHERE ap.id= :appointmentId ";

        Query query = entityManager.createNativeQuery(sql).setParameter("appointmentId", appointmentId);

        query.unwrap(NativeQuery.class)
                .addScalar("appointmentId", StandardBasicTypes.LONG)
                .addScalar("patientId", StandardBasicTypes.LONG)
                .addScalar("appointmentDate", StandardBasicTypes.LOCAL_DATE)
                .addScalar("profilePhoto", StandardBasicTypes.STRING)
                .addScalar("emailId", StandardBasicTypes.STRING)
                .addScalar("gender", StandardBasicTypes.STRING)
                .addScalar("phoneNumber", StandardBasicTypes.STRING)
                .addScalar("zipCode", StandardBasicTypes.STRING);

        ((NativeQuery) query).setResultTransformer(Transformers.aliasToBean(PatientDetailsDTO.class));

        try {
            return (PatientDetailsDTO) query.getSingleResult();
        } catch (NoResultException e) {
            return null; // Handle the case when no result is found
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving patient details", e);
        }
    }
}
