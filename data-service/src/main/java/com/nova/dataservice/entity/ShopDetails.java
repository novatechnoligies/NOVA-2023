package com.nova.dataservice.entity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "shop_details")
public class ShopDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "shop_name")
	private String shopName;
	
	@Column(name = "shop_address")
	private String shopAddress;
	
	@Column(name = "latitude")
	private Long latitude;
	
	@Column(name = "longitude")
	private Long longitude;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "created_at")
	private LocalDate createdAt;
	
	@Column(name = "status")
	private Boolean status;
	
	@Column(name = "is_deleted")
	private Boolean isDeleted;
	
	@Column(name = "printer_required")
	private Boolean printerRequired;
	
	@Column(name = "logo")
	private String logo;
	
	@Column(name = "device_required")
	private Boolean deviceRequired;
	
	@Column(name = "inventory")
	private Boolean inventory;
	
	@Column(name = "enable_gift_card")
	private Boolean enableGiftCard;
	
	@Column(name = "pin_code")
	private String pinCode;
	
	@Column(name = "shop_code")
	private Boolean shopCode;
	
	@Column(name = "gst_no")
	private String gstNo;
	
	@Column(name = "capacity")// indiactes employee count and no of appointments handle in same slot
	private Long capacity;
	
	@Column (name = "amenities")// incules Wi-fi parking , TV, restroom 
	private String amenities;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "shop_type_id")
	@JsonIgnore
	private ShopType shopType;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private UserDetails owner;
	
	@OneToMany(mappedBy = "shop")
	@JsonIgnore
	private List<ShopAvalibility> timeAvailabilities = new ArrayList<>();

	@OneToMany(mappedBy = "shop")
	@JsonIgnore
	private List<ServiceMasterShopRelation> shopServices = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopAddress() {
		return shopAddress;
	}

	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}

	public Long getLatitude() {
		return latitude;
	}

	public void setLatitude(Long latitude) {
		this.latitude = latitude;
	}

	public Long getLongitude() {
		return longitude;
	}

	public void setLongitude(Long longitude) {
		this.longitude = longitude;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
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

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public ShopType getShopType() {
		return shopType;
	}

	public void setShopType(ShopType shopType) {
		this.shopType = shopType;
	}

	public UserDetails getOwner() {
		return owner;
	}

	public void setOwner(UserDetails owner) {
		this.owner = owner;
	}

	public List<ShopAvalibility> getTimeAvailabilities() {
		return timeAvailabilities;
	}

	public void setTimeAvailabilities(List<ShopAvalibility> timeAvailabilities) {
		this.timeAvailabilities = timeAvailabilities;
	}

	public List<ServiceMasterShopRelation> getShopServices() {
		return shopServices;
	}

	public void setShopServices(List<ServiceMasterShopRelation> shopServices) {
		this.shopServices = shopServices;
	}

	public Boolean getPrinterRequired() {
		return printerRequired;
	}

	public void setPrinterRequired(Boolean printerRequired) {
		this.printerRequired = printerRequired;
	}

	public Boolean getDeviceRequired() {
		return deviceRequired;
	}

	public void setDeviceRequired(Boolean deviceRequired) {
		this.deviceRequired = deviceRequired;
	}

	public Boolean getInventory() {
		return inventory;
	}

	public void setInventory(Boolean inventory) {
		this.inventory = inventory;
	}

	public Boolean getEnableGiftCard() {
		return enableGiftCard;
	}

	public void setEnableGiftCard(Boolean enableGiftCard) {
		this.enableGiftCard = enableGiftCard;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public Boolean getShopCode() {
		return shopCode;
	}

	public void setShopCode(Boolean shopCode) {
		this.shopCode = shopCode;
	}

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	

}
