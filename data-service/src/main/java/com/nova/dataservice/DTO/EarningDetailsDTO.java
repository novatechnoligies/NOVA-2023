package com.nova.dataservice.DTO;

public class EarningDetailsDTO {
	private Long ownerId;
	
	private Float todaysEarnings;
	
	private Float totalEarnings;

	
	/**
	 * @return the todaysEarnings
	 */
	public Float getTodaysEarnings() {
		return todaysEarnings;
	}

	/**
	 * @param todaysEarnings the todaysEarnings to set
	 */
	public void setTodaysEarnings(Float todaysEarnings) {
		this.todaysEarnings = todaysEarnings;
	}

	/**
	 * @return the totalEarnings
	 */
	public Float getTotalEarnings() {
		return totalEarnings;
	}

	/**
	 * @param totalEarnings the totalEarnings to set
	 */
	public void setTotalEarnings(Float totalEarnings) {
		this.totalEarnings = totalEarnings;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	

}
