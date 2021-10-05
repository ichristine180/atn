/**
 * 
 */
package com.atn.utils;

/**
 * @author christine
 *
 */
public class MnoRealAccountRecorderResponse {
	private int mnoRealAccountRecorderId;
	private Long totalAmount;
	public int getMnoRealAccountRecorderId() {
		return mnoRealAccountRecorderId;
	}
	public void setMnoRealAccountRecorderId(int mnoRealAccountRecorderId) {
		this.mnoRealAccountRecorderId = mnoRealAccountRecorderId;
	}
	public Long getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Long totalAmount) {
		this.totalAmount = totalAmount;
	}
	public MnoRealAccountRecorderResponse(int mnoRealAccountRecorderId, Long totalAmount) {
		super();
		this.mnoRealAccountRecorderId = mnoRealAccountRecorderId;
		this.totalAmount = totalAmount;
	}
	
}
