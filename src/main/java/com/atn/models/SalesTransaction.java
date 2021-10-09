package com.atn.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author christine
 *
 */

@Entity
@Table(name = "SALES_TRANSACTION")
public class SalesTransaction {
	@Id
	@NotEmpty(message = "id can not be null")
	@Size(max = 90, message = "id must be 90 long")
	@Column(name = "id", length = 90)
	private String id;

	@NotEmpty(message = "Account id can not be null")
	@Size(max = 90, message = "acount id must be 90 long")
	@Column(name = "accountId", nullable = false, length = 90)
	private String accountId;
	
	@NotEmpty(message = "resellerProuctId  can not be null")
	@Column(name = "resellerProuctId", length = 90)
	private String resellerProuctId;
	@Min(value = 0, message = "amount is required")
	@Column(name = "amount", nullable = false)
	private int amount;

	@Size(max = 30, message = "destination must be 30 long")
	@Column(name = "destination", length = 30)
	private String destination;
	@NotNull(message="resellerMovementRecorder can not be null")
	private Integer resellerMovementRecorder;
	@NotNull(message="mnoRealAccountRecorder can not be null")
	private Integer mnoRealAccountRecorder;
	@NotNull(message="mnoNormalAccountRecorded can not be null")
	private Integer mnoNormalAccountRecorded;

	@NotEmpty(message = "status  can not be null")
	@Size(max = 12, message = "status must be 12 long")
	@Column(name = "status", length = 12)
	private String status;
	private String date;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getResellerProuctId() {
		return resellerProuctId;
	}

	public void setResellerProuctId(String resellerProuctId) {
		this.resellerProuctId = resellerProuctId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getResellerMovementRecorder() {
		return resellerMovementRecorder;
	}

	public void setResellerMovementRecorder(int resellerMovementRecorder) {
		this.resellerMovementRecorder = resellerMovementRecorder;
	}

	public int getMnoRealAccountRecorder() {
		return mnoRealAccountRecorder;
	}

	public void setMnoRealAccountRecorder(int mnoRealAccountRecorder) {
		this.mnoRealAccountRecorder = mnoRealAccountRecorder;
	}

	public int getMnoNormalAccountRecorded() {
		return mnoNormalAccountRecorded;
	}

	public void setMnoNormalAccountRecorded(int mnoNormalAccountRecorded) {
		this.mnoNormalAccountRecorded = mnoNormalAccountRecorded;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @param resellerMovementRecorder the resellerMovementRecorder to set
	 */
	public void setResellerMovementRecorder(Integer resellerMovementRecorder) {
		this.resellerMovementRecorder = resellerMovementRecorder;
	}

	/**
	 * @param mnoRealAccountRecorder the mnoRealAccountRecorder to set
	 */
	public void setMnoRealAccountRecorder(Integer mnoRealAccountRecorder) {
		this.mnoRealAccountRecorder = mnoRealAccountRecorder;
	}

	/**
	 * @param mnoNormalAccountRecorded the mnoNormalAccountRecorded to set
	 */
	public void setMnoNormalAccountRecorded(Integer mnoNormalAccountRecorded) {
		this.mnoNormalAccountRecorded = mnoNormalAccountRecorded;
	}

	@Override
	public String toString() {
		return "SalesTransaction [id=" + id + ", resellerProuctId=" + resellerProuctId + ", amount=" + amount
				+ ", destination=" + destination + ", resellerMovementRecorder=" + resellerMovementRecorder
				+ ", mnoRealAccountRecorder=" + mnoRealAccountRecorder + ", mnoNormalAccountRecorded="
				+ mnoNormalAccountRecorded + ", status=" + status + ", date=" + date + ", accountId=" + accountId + "]";
	}

}
