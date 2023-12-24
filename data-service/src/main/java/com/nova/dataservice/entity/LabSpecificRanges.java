package com.nova.dataservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "lab_specific_ranges")
public class LabSpecificRanges {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lab_id", nullable = false)
    private ShopDetails labData;

    @ManyToOne
    @JoinColumn(name = "test_id", nullable = false)
    private ServiceMaster labTest;

    @ManyToOne
    @JoinColumn(name = "param_id", nullable = false)
    private ServiceMasterParameter testParameters;

    @Column(name = "male_normal_range_min")
    private Double maleNormalRangeMin;

    @Column(name = "male_normal_range_max")
    private Double maleNormalRangeMax;

    @Column(name = "female_normal_range_min")
    private Double femaleNormalRangeMin;

    @Column(name = "female_normal_range_max")
    private Double femaleNormalRangeMax;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ShopDetails getLabData() {
		return labData;
	}

	public void setLabData(ShopDetails labData) {
		this.labData = labData;
	}

	public ServiceMaster getLabTest() {
		return labTest;
	}

	public void setLabTest(ServiceMaster labTest) {
		this.labTest = labTest;
	}

	public ServiceMasterParameter getTestParameters() {
		return testParameters;
	}

	public void setTestParameters(ServiceMasterParameter testParameters) {
		this.testParameters = testParameters;
	}

	public Double getMaleNormalRangeMin() {
		return maleNormalRangeMin;
	}

	public void setMaleNormalRangeMin(Double maleNormalRangeMin) {
		this.maleNormalRangeMin = maleNormalRangeMin;
	}

	public Double getMaleNormalRangeMax() {
		return maleNormalRangeMax;
	}

	public void setMaleNormalRangeMax(Double maleNormalRangeMax) {
		this.maleNormalRangeMax = maleNormalRangeMax;
	}

	public Double getFemaleNormalRangeMin() {
		return femaleNormalRangeMin;
	}

	public void setFemaleNormalRangeMin(Double femaleNormalRangeMin) {
		this.femaleNormalRangeMin = femaleNormalRangeMin;
	}

	public Double getFemaleNormalRangeMax() {
		return femaleNormalRangeMax;
	}

	public void setFemaleNormalRangeMax(Double femaleNormalRangeMax) {
		this.femaleNormalRangeMax = femaleNormalRangeMax;
	}
    
}
