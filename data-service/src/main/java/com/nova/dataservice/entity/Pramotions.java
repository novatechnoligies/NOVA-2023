package com.nova.dataservice.entity;

import java.time.LocalDate;
import java.util.Date;

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
	
	@Column(name = "shop_id")
	private Long shopId;
	
	@Column(name = "promotion_name")
	private String promotionName;
	
	@Column(name = "created_at")
	private Date createdAt;
	
	@Column(name = "total_price")
	private Float totalPrice;
	
	@Column(name = "offer_in_for")
	private Boolean offerInFor;
	
	@Column(name = "percentage")
	private Long precentage;
	
	@Column(name = "offer_in_amount")
	private Boolean offerInAmount;
	
	@Column(name = "promotion_img")
	private String promotionImg;
	
	@Column(name = "is_pushed_notification")
	private Boolean isPushedNotification;
	
	
	public Long getId() {
		return id;
	}
	@Id
	@Column
	public void setId(Long id) {
		this.id = id;
	}
	@Column
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	@Column
	public LocalDate getExpDate() {
		return expDate;
	}
	public void setExpDate(LocalDate expDate) {
		this.expDate = expDate;
	}
	@Column
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	@Column
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	@Column
	public Boolean getIsUsed() {
		return isUsed;
	}
	public void setIsUsed(Boolean isUsed) {
		this.isUsed = isUsed;
	}
	@Column
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	@Column
	public Float getPramotionAmount() {
		return pramotionAmount;
	}
	public void setPramotionAmount(Float pramotionAmount) {
		this.pramotionAmount = pramotionAmount;
	}
	public Long getShopId() {
		return shopId;
	}
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
	
	public String getPromotionName() {
		return promotionName;
	}
	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Boolean getOfferInFor() {
		return offerInFor;
	}
	public void setOfferInFor(Boolean offerInFor) {
		this.offerInFor = offerInFor;
	}
	public Long getPrecentage() {
		return precentage;
	}
	public void setPrecentage(Long precentage) {
		this.precentage = precentage;
	}
	public Boolean getOfferInAmount() {
		return offerInAmount;
	}
	public void setOfferInAmount(Boolean offerInAmount) {
		this.offerInAmount = offerInAmount;
	}
	public String getPromotionImg() {
		return promotionImg;
	}
	public void setPromotionImg(String promotionImg) {
		this.promotionImg = promotionImg;
	}
	public Boolean getIsPushedNotification() {
		return isPushedNotification;
	}
	public void setIsPushedNotification(Boolean isPushedNotification) {
		this.isPushedNotification = isPushedNotification;
	}
		
	
	

}

