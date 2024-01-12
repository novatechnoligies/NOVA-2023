package com.nova.dataservice.DTO;

import java.time.LocalDate;

public class PatientDetailsDTO {

	private Long patientId;
	
	private String profilePhoto;
	
	private Long pastAppointmentsCount;
	
	private Long upcomingAppointmentsCounts;
	
	private String gender;
	
	private String phoneNumber;
	
	private String emailId;
	
	private LocalDate AppointmentDate;
	
	private LocalDate birthday;
	
	private String address;
	
	private String zipCode;
	
	private String city;
	
	private String memberStatus;
	
	private Long appointmentId;
	
	private String patientName;

	/**
	 * @return the petienttId
	 */
	

	/**
	 * @return the profilePhoto
	 */
	public String getProfilePhoto() {
		return profilePhoto;
	}

	/**
	 * @param profilePhoto the profilePhoto to set
	 */
	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

	/**
	 * @return the pastAppointmentsCount
	 */
	public Long getPastAppointmentsCount() {
		return pastAppointmentsCount;
	}

	/**
	 * @param pastAppointmentsCount the pastAppointmentsCount to set
	 */
	public void setPastAppointmentsCount(Long pastAppointmentsCount) {
		this.pastAppointmentsCount = pastAppointmentsCount;
	}

	/**
	 * @return the upcomingAppointmentsCounts
	 */
	public Long getUpcomingAppointmentsCounts() {
		return upcomingAppointmentsCounts;
	}

	/**
	 * @param upcomingAppointmentsCounts the upcomingAppointmentsCounts to set
	 */
	public void setUpcomingAppointmentsCounts(Long upcomingAppointmentsCounts) {
		this.upcomingAppointmentsCounts = upcomingAppointmentsCounts;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the appointmentDate
	 */
	public LocalDate getAppointmentDate() {
		return AppointmentDate;
	}

	/**
	 * @param appointmentDate the appointmentDate to set
	 */
	public void setAppointmentDate(LocalDate appointmentDate) {
		AppointmentDate = appointmentDate;
	}

	/**
	 * @return the birthday
	 */
	public LocalDate getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the memberStatus
	 */
	public String getMemberStatus() {
		return memberStatus;
	}

	/**
	 * @param memberStatus the memberStatus to set
	 */
	public void setMemberStatus(String memberStatus) {
		this.memberStatus = memberStatus;
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

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	
}
