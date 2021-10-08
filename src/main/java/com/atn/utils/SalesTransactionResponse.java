/**
 * 
 */
package com.atn.utils;

import java.util.List;

import com.atn.models.SalesTransaction;

/**
 * @author christine
 *
 */
public class SalesTransactionResponse {
	private SalesTransaction data;

	private Boolean error;
	private String Message;
	private List<String> validationError;

	public List<String> getValidationError() {
		return validationError;
	}

	public void setValidationError(List<String> validationError) {
		this.validationError = validationError;
	}

	

	public SalesTransaction getData() {
		return data;
	}

	public void setData(SalesTransaction data) {
		this.data = data;
	}

	public Boolean getError() {
		return error;
	}

	public void setError(Boolean error) {
		this.error = error;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

}
