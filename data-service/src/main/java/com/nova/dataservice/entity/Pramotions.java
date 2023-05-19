package com.nova.dataservice.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pramotions")
public class Pramotions {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Long id;
	@Column(name = "start_date")
	private LocalDate startDate;
	@Column(name = "exp_date")
	private LocalDate expDate;
	@Column(name = "status")
	private Boolean status;
	@Column(name = "is_deleyted" )
	private Boolean isDeleted;
	@Column(name = "is_used")
	private Boolean isUsed;
	@Column(name = "created_by")
	private Long createdBy;
	@Column(name = "pramotion_amount")
	private Float pramotionAmount;

}
