package com.nova.dataservice.entity;

import java.time.LocalDate;
import java.time.LocalTime;

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
@Table(name = "employe_tracking")
public class EmployeTracking {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
	@JoinColumn(name = "emp_id")
	private EmployeeDetails empId;

	@Column (name="login_time")
    private LocalTime login_time;
    
    @Column (name="logout_time")
    private LocalTime logoutTime;
    
    @Column (name="from_date")
    private LocalDate fromDate;
    
    @Column (name="to_date")
    private LocalDate toDate;
    
	@Column(name = "comments")
    private String comments;
    
	@Column (name="created_at")
    private LocalDate createdAt;
    
    @Column (name="status")
    private Boolean status;
    
    @Column (name="target")
    private String target;
    
    @Column (name="target_type")
    private String targetType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EmployeeDetails getEmpId() {
		return empId;
	}

	public void setEmpId(EmployeeDetails empId) {
		this.empId = empId;
	}

	public LocalTime getLogin_time() {
		return login_time;
	}

	public void setLogin_time(LocalTime login_time) {
		this.login_time = login_time;
	}

	public LocalTime getLogoutTime() {
		return logoutTime;
	}

	public void setLogoutTime(LocalTime logoutTime) {
		this.logoutTime = logoutTime;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getTargetType() {
		return targetType;
	}

	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}
    
    

}
