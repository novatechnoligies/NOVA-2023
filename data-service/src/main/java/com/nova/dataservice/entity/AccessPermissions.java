package com.nova.dataservice.entity;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="access_permissions")
public class AccessPermissions {
	
	private Long id;
	
	
	private UserDetails employeeDetails;
	
	
	private ShopDetails shopDetails;
	
	private String items;
	
	private Long createdBy;
	
	
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
	
	private Boolean accessPermissionStatus;
	
	private Date createdAt;
	
	private Long accessPermissions;
	
	private Date accessPermissionFromDate;
	
	private Date accessPermissionsToDate;

	public AccessPermissions() {
		super();
	}


	/**
	 * @return the id
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="id")
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
	 * @return the employee
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id")
	public UserDetails getEmployeeDetails() {
		return employeeDetails;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployeeDetails(UserDetails employeeDetails) {
		this.employeeDetails = employeeDetails;
	}

	/**
	 * @return the shopDetails
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "shop_id")
	public ShopDetails getShopDetails() {
		return shopDetails;
	}

	/**
	 * @param shopDetails the shopDetails to set
	 */
	public void setShopDetails(ShopDetails shopDetails) {
		this.shopDetails = shopDetails;
	}

	/**
	 * @return the createLab
	 */
	@Column(name="create_lab")
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
	@Column(name="updated_lab")
	public Boolean getUpdatedLab() {
		return updatedLab;
	}

	/**
	 * @param updatedLab the upadatedLab to set
	 */
	public void setUpdatedLab(Boolean updatedLab) {
		this.updatedLab = updatedLab;
	}

	/**
	 * @return the deletedLab
	 */
	@Column(name="deleted_lab")
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
	@Column(name="lab_availability")
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
	@Column(name="create_service")
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
	@Column(name="updated_service")
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
	@Column(name ="deleted_service")
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
	@Column(name = "services_pricing")
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
	@Column(name ="create_appointment" )
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
	@Column(name ="updated_appointment" )
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
	@Column(name ="deleted_appointment" )
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
	@Column(name ="appointmentList" )
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
	@Column(name ="create_employee" )
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
	@Column(name ="updated_employee" )
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
	@Column(name ="deleted_employee" )
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
	@Column(name ="employee_login" )
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
	@Column(name ="employee_logOut" )
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
	@Column(name ="employee_management" )
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
	@Column(name ="create_inventory" )
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
	@Column(name ="updated_inventory" )
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
	@Column(name ="deleted_inventory" )
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
	@Column(name ="import_inventory" )
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
	@Column(name ="usedInventries" )
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
	@Column(name ="access_peermissions_status" )
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
	@Column(name ="created_at" )
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
	@Column(name ="access_permission" )
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
	@Column(name ="access_permissions_from_date" )
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
	@Column(name ="access_permissions_to_date" )
	public Date getAccessPermissionsToDate() {
		return accessPermissionsToDate;
	}

	/**
	 * @param accessPermissionsToDate the accessPermissionsToDate to set
	 */
	public void setAccessPermissionsToDate(Date accessPermissionsToDate) {
		this.accessPermissionsToDate = accessPermissionsToDate;
	}


	@Column(name = "items")
	public String getItems() {
		return items;
	}


	public void setItems(String items) {
		this.items = items;
	}

	@Column(name = "created_by")
	public Long getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	

	
}
