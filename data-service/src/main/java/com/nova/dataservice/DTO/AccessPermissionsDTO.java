package com.nova.dataservice.DTO;

import java.util.Date;

import com.nova.dataservice.entity.ShopDetails;
import com.nova.dataservice.entity.UserDetails;

public class AccessPermissionsDTO {
	
    private Long id;
	
	private Boolean createLab;
	 
	private Boolean updatedLab;
	
	private Boolean deletedLab;
	
	private Boolean labAvailability;
	
	private Boolean createServices;
	
	private Boolean updatedServices;
	
	private Boolean deletedServices;
	
	private Boolean servicesPricing;
	
	private Boolean createAppointments;
	
	private Boolean updatedAppointments;
	
	private Boolean deletedAppointments;
	
	private Boolean appointmentList;
	
	private Boolean creatEmployee;
	
	private Boolean updatedEmployee;
	
	private Boolean deletedEmployee;
	
	private Boolean employeeLogin;
	
	private Boolean employeeLogOut;
	
	private Boolean employeeManagement;
	
	private Boolean createInventory;
	
	private Boolean updatedInventory;
	
	private Boolean deletedInventory;
	
	private Boolean importInventory;
	
	private Boolean usedInventories;
	
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
	 * @return the createLab
	 */
	public Boolean getCreateLab() {
		return createLab;
	}

	/**
	 * @param createLab the createLab to set
	 */
	public void setCreateLab(Boolean createLab) {
		this.createLab = createLab;
	}

	/**
	 * @return the updatedLab
	 */
	public Boolean getUpdatedLab() {
		return updatedLab;
	}

	/**
	 * @param updatedLab the updatedLab to set
	 */
	public void setUpdatedLab(Boolean updatedLab) {
		this.updatedLab = updatedLab;
	}

	/**
	 * @return the deletedLab
	 */
	public Boolean getDeletedLab() {
		return deletedLab;
	}

	/**
	 * @param deletedLab the deletedLab to set
	 */
	public void setDeletedLab(Boolean deletedLab) {
		this.deletedLab = deletedLab;
	}

	/**
	 * @return the labAvailability
	 */
	public Boolean getLabAvailability() {
		return labAvailability;
	}

	/**
	 * @param labAvailability the labAvailability to set
	 */
	public void setLabAvailability(Boolean labAvailability) {
		this.labAvailability = labAvailability;
	}

	/**
	 * @return the createServices
	 */
	public Boolean getCreateServices() {
		return createServices;
	}

	/**
	 * @param createServices the createServices to set
	 */
	public void setCreateServices(Boolean createServices) {
		this.createServices = createServices;
	}

	/**
	 * @return the updatedServices
	 */
	public Boolean getUpdatedServices() {
		return updatedServices;
	}

	/**
	 * @param updatedServices the updatedServices to set
	 */
	public void setUpdatedServices(Boolean updatedServices) {
		this.updatedServices = updatedServices;
	}

	/**
	 * @return the deletedServices
	 */
	public Boolean getDeletedServices() {
		return deletedServices;
	}

	/**
	 * @param deletedServices the deletedServices to set
	 */
	public void setDeletedServices(Boolean deletedServices) {
		this.deletedServices = deletedServices;
	}

	/**
	 * @return the servicesPricing
	 */
	public Boolean getServicesPricing() {
		return servicesPricing;
	}

	/**
	 * @param servicesPricing the servicesPricing to set
	 */
	public void setServicesPricing(Boolean servicesPricing) {
		this.servicesPricing = servicesPricing;
	}

	/**
	 * @return the createAppointments
	 */
	public Boolean getCreateAppointments() {
		return createAppointments;
	}

	/**
	 * @param createAppointments the createAppointments to set
	 */
	public void setCreateAppointments(Boolean createAppointments) {
		this.createAppointments = createAppointments;
	}

	/**
	 * @return the updatedAppointments
	 */
	public Boolean getUpdatedAppointments() {
		return updatedAppointments;
	}

	/**
	 * @param updatedAppointments the updatedAppointments to set
	 */
	public void setUpdatedAppointments(Boolean updatedAppointments) {
		this.updatedAppointments = updatedAppointments;
	}

	/**
	 * @return the deletedAppointments
	 */
	public Boolean getDeletedAppointments() {
		return deletedAppointments;
	}

	/**
	 * @param deletedAppointments the deletedAppointments to set
	 */
	public void setDeletedAppointments(Boolean deletedAppointments) {
		this.deletedAppointments = deletedAppointments;
	}

	/**
	 * @return the appointmentList
	 */
	public Boolean getAppointmentList() {
		return appointmentList;
	}

	/**
	 * @param appointmentList the appointmentList to set
	 */
	public void setAppointmentList(Boolean appointmentList) {
		this.appointmentList = appointmentList;
	}

	/**
	 * @return the creatEmployee
	 */
	public Boolean getCreatEmployee() {
		return creatEmployee;
	}

	/**
	 * @param creatEmployee the creatEmployee to set
	 */
	public void setCreatEmployee(Boolean creatEmployee) {
		this.creatEmployee = creatEmployee;
	}

	/**
	 * @return the updatedEmployee
	 */
	public Boolean getUpdatedEmployee() {
		return updatedEmployee;
	}

	/**
	 * @param updatedEmployee the updatedEmployee to set
	 */
	public void setUpdatedEmployee(Boolean updatedEmployee) {
		this.updatedEmployee = updatedEmployee;
	}

	/**
	 * @return the deletedEmployee
	 */
	public Boolean getDeletedEmployee() {
		return deletedEmployee;
	}

	/**
	 * @param deletedEmployee the deletedEmployee to set
	 */
	public void setDeletedEmployee(Boolean deletedEmployee) {
		this.deletedEmployee = deletedEmployee;
	}

	/**
	 * @return the employeeLogin
	 */
	public Boolean getEmployeeLogin() {
		return employeeLogin;
	}

	/**
	 * @param employeeLogin the employeeLogin to set
	 */
	public void setEmployeeLogin(Boolean employeeLogin) {
		this.employeeLogin = employeeLogin;
	}

	/**
	 * @return the employeeLogOut
	 */
	public Boolean getEmployeeLogOut() {
		return employeeLogOut;
	}

	/**
	 * @param employeeLogOut the employeeLogOut to set
	 */
	public void setEmployeeLogOut(Boolean employeeLogOut) {
		this.employeeLogOut = employeeLogOut;
	}

	/**
	 * @return the employeeManagement
	 */
	public Boolean getEmployeeManagement() {
		return employeeManagement;
	}

	/**
	 * @param employeeManagement the employeeManagement to set
	 */
	public void setEmployeeManagement(Boolean employeeManagement) {
		this.employeeManagement = employeeManagement;
	}

	/**
	 * @return the createInventory
	 */
	public Boolean getCreateInventory() {
		return createInventory;
	}

	/**
	 * @param createInventory the createInventory to set
	 */
	public void setCreateInventory(Boolean createInventory) {
		this.createInventory = createInventory;
	}

	/**
	 * @return the updatedInventory
	 */
	public Boolean getUpdatedInventory() {
		return updatedInventory;
	}

	/**
	 * @param updatedInventory the updatedInventory to set
	 */
	public void setUpdatedInventory(Boolean updatedInventory) {
		this.updatedInventory = updatedInventory;
	}

	/**
	 * @return the deletedInventory
	 */
	public Boolean getDeletedInventory() {
		return deletedInventory;
	}

	/**
	 * @param deletedInventory the deletedInventory to set
	 */
	public void setDeletedInventory(Boolean deletedInventory) {
		this.deletedInventory = deletedInventory;
	}

	/**
	 * @return the importInventory
	 */
	public Boolean getImportInventory() {
		return importInventory;
	}

	/**
	 * @param importInventory the importInventory to set
	 */
	public void setImportInventory(Boolean importInventory) {
		this.importInventory = importInventory;
	}

	/**
	 * @return the usedInventories
	 */
	public Boolean getUsedInventories() {
		return usedInventories;
	}

	/**
	 * @param usedInventories the usedInventories to set
	 */
	public void setUsedInventories(Boolean usedInventories) {
		this.usedInventories = usedInventories;
	}

	/**
	 * @return the accessPermissionStatus
	 */
	public Boolean getAccessPermissionStatus() {
		return accessPermissionStatus;
	}

	/**
	 * @param accessPermissionStatus the accessPermissionStatus to set
	 */
	public void setAccessPermissionStatus(Boolean accessPermissionStatus) {
		this.accessPermissionStatus = accessPermissionStatus;
	}

	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the accessPermissions
	 */
	public Long getAccessPermissions() {
		return accessPermissions;
	}

	/**
	 * @param accessPermissions the accessPermissions to set
	 */
	public void setAccessPermissions(Long accessPermissions) {
		this.accessPermissions = accessPermissions;
	}

	/**
	 * @return the accessPermissionFromDate
	 */
	public Date getAccessPermissionFromDate() {
		return accessPermissionFromDate;
	}

	/**
	 * @param accessPermissionFromDate the accessPermissionFromDate to set
	 */
	public void setAccessPermissionFromDate(Date accessPermissionFromDate) {
		this.accessPermissionFromDate = accessPermissionFromDate;
	}

	/**
	 * @return the accessPermissionsToDate
	 */
	public Date getAccessPermissionsToDate() {
		return accessPermissionsToDate;
	}

	/**
	 * @param accessPermissionsToDate the accessPermissionsToDate to set
	 */
	public void setAccessPermissionsToDate(Date accessPermissionsToDate) {
		this.accessPermissionsToDate = accessPermissionsToDate;
	}

	private Boolean accessPermissionStatus;
	
	private Date createdAt;
	
	private Long accessPermissions;
	
	private Date accessPermissionFromDate;
	
	private Date accessPermissionsToDate;



}
