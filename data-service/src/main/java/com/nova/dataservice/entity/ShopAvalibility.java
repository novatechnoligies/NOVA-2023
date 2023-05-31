package com.nova.dataservice.entity;

import java.time.LocalDate;
import java.time.LocalTime;

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
@Table(name = "shop_avalibility")
public class ShopAvalibility {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fromDate;

    private LocalDate toDate;

    private LocalTime fromTime;

    private LocalTime toTime;
    
    private Long timeInterval;

    // Other fields
    

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
    private ShopDetails shop;
    
   
   @Column
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
   @Column
	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}
	@Column

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}
	@Column

	public LocalTime getFromTime() {
		return fromTime;
	}

	public void setFromTime(LocalTime fromTime) {
		this.fromTime = fromTime;
	}
	@Column

	public LocalTime getToTime() {
		return toTime;
	}

	public void setToTime(LocalTime toTime) {
		this.toTime = toTime;
	}
	@Column

	public ShopDetails getShop() {
		return shop;
	}

	public void setShop(ShopDetails shop) {
		this.shop = shop;
	}

	@Column
		public Long getTimeInterval() {
		return timeInterval;
	}

	public void setTimeInterval(Long timeInterval) {
		this.timeInterval = timeInterval;
	}
    
    
}
