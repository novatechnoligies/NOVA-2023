package com.nova.demo.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "appointment_details")
public class AppontmentDetails {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "shop_id", nullable = false)
    private ShopDetails shop;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserDetails user;

    @ManyToOne
    @JoinColumn(name = "slot_id", nullable = false)
    private SlotAvailability slot;
    
    @Column(name = "appointment_status")
    private String appointmentStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ShopDetails getShop() {
		return shop;
	}

	public void setShop(ShopDetails shop) {
		this.shop = shop;
	}

	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}

	public SlotAvailability getSlot() {
		return slot;
	}

	public void setSlot(SlotAvailability slot) {
		this.slot = slot;
	}

	public String getAppointmentStatus() {
		return appointmentStatus;
	}

	public void setAppointmentStatus(String appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}
    
}
