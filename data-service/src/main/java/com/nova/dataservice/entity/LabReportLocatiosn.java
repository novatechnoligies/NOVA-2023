package com.nova.dataservice.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="lab_report_locations")
public class LabReportLocatiosn {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name="file_name")
	private String fileName;
	
	@Column(name="file_data")
    private byte[] fileData;
	
	@Column(name="patient_id")
    private Long patientId;
	
	@Column(name="lab_id")
    private Long labId;
	
	@Column(name="technician_id")
    private Long technicianId;
	
	@Column(name="appointment_id")
    private Long appointmentId;
	
	@Column(name = "created_at")
	private LocalDate createdAt;
	
	@Column(name="result")
    private String results;
	
	@Column(name="test_id")
    private String testId;
	
	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public String getResults() {
		return results;
	}

	public void setResult(String results) {
		this.results = results;
	}

	/**
	 * @return the appointmentId
	 */
	public Long getAppointmentId() {
		return appointmentId;
	}

	/**
	 * @param appointmentId the appointmentId to set
	 */
	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}

	public LabReportLocatiosn() {
		super();
	}

	public LabReportLocatiosn(Long id, String fileName, byte[] fileData, Long patientId, Long labId, Long technicianId) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.fileData = fileData;
		this.patientId = patientId;
		this.labId = labId;
		this.technicianId = technicianId;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the fileData
	 */
	public byte[] getFileData() {
		return fileData;
	}

	/**
	 * @param fileData the fileData to set
	 */
	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	/**
	 * @return the patientId
	 */
	public Long getPatientId() {
		return patientId;
	}

	/**
	 * @param patientId the patientId to set
	 */
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	/**
	 * @return the labId
	 */
	public Long getLabId() {
		return labId;
	}

	/**
	 * @param labId the labId to set
	 */
	public void setLabId(Long labId) {
		this.labId = labId;
	}

	/**
	 * @return the technicianId
	 */
	public Long getTechnicianId() {
		return technicianId;
	}

	/**
	 * @param technicianId the technicianId to set
	 */
	public void setTechnicianId(Long technicianId) {
		this.technicianId = technicianId;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

    
}
