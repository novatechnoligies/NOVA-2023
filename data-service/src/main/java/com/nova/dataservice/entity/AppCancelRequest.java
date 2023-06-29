package com.nova.dataservice.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="app_cancel_request")
public class AppCancelRequest 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="slot_id")
	private Long slotId;
	@Column (name="requested_by")
	private Boolean requestedBy;
	@Column (name="reason")
	private Boolean reason;
	@Column (name="comments")
	private Boolean comments;
	@Column (name="extended_by_status")
	private Boolean extendedByStatus;
	@Column (name="status")
	private Boolean status;
	@Column (name="is_deleted")
	private Boolean isDeleted;
	@Column (name="cancelation_status")
	private Boolean cancelationSatus;
	public Long getSlotId() {
		return slotId;
	}
	public void setSlotId(Long slotId) {
		this.slotId = slotId;
	}
	public Boolean getRequestedBy() {
		return requestedBy;
	}
	public void setRequestedBy(Boolean requestedBy) {
		this.requestedBy = requestedBy;
	}
	public Boolean getReason() {
		return reason;
	}
	public void setReason(Boolean reason) {
		this.reason = reason;
	}
	public Boolean getComments() {
		return comments;
	}
	public void setComments(Boolean comments) {
		this.comments = comments;
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
	
	public Boolean getExtendedByStatus() {
		return extendedByStatus;
	}
	public void setExtendedByStatus(Boolean extendedByStatus) {
		this.extendedByStatus = extendedByStatus;
	}
	public Boolean getCancelationSatus() {
		return cancelationSatus;
	}
	public void setCancelationSatus(Boolean cancelationSatus) {
		this.cancelationSatus = cancelationSatus;
	}



}
