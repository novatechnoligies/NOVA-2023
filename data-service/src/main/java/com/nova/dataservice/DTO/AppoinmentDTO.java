package com.nova.dataservice.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppoinmentDTO {
	
	private Long appointmentId;
	private String patientName;
	private LocalDate appointmentDate;
	private LocalTime appointmentTime;
	private String photo;
	private String patientPhone;
	private String appointmentStatus;
	private String patientAdhar;
	private Long shopId;
	
	public Long getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getPatientPhone() {
		return patientPhone;
	}
	public void setPatientPhone(String patientPhone) {
		this.patientPhone = patientPhone;
	}
	public String getAppointmentStatus() {
		return appointmentStatus;
	}
	public void setAppointmentStatus(String appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}
	public String getPatientAdhar() {
		return patientAdhar;
	}
	public void setPatientAdhar(String patientAdhar) {
		this.patientAdhar = patientAdhar;
	}
	public Long getShopId() {
		return shopId;
	}
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
	public LocalTime getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(LocalTime appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	
	
	

}
