package com.nova.dataservice.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentTrackingDTO {

	private Long appointmentId;
	private Long patientId;
	private Long labId;
	private LocalDate AppointmentDate;
	private LocalTime AppointmentTime;
	private String testName;
	private String technicianName;
	private Long technicianId;
	private Boolean AppointmentStatus;
	
	public Long getTechnicianId() {
		return technicianId;
	}
	public void setTechnicianId(Long technicianId) {
		this.technicianId = technicianId;
	}
	public Boolean getAppointmentStatus() {
		return AppointmentStatus;
	}
	public void setAppointmentStatus(Boolean appointmentStatus) {
		AppointmentStatus = appointmentStatus;
	}
	public Long getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public Long getLabId() {
		return labId;
	}
	public void setLabId(Long labId) {
		this.labId = labId;
	}
	public LocalDate getAppointmentDate() {
		return AppointmentDate;
	}
	public void setAppointmentDate(LocalDate appointmentDate) {
		AppointmentDate = appointmentDate;
	}
	public LocalTime getAppointmentTime() {
		return AppointmentTime;
	}
	public void setAppointmentTime(LocalTime appointmentTime) {
		AppointmentTime = appointmentTime;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public String getTechnicianName() {
		return technicianName;
	}
	public void setTechnicianName(String technicianName) {
		this.technicianName = technicianName;
	}
	
	
	 
}
