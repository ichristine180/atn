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
public class Response {
	private Integer currentPage;
	private Integer totalItems;
	private List<SalesTransaction> data;

	public List<SalesTransaction> getData() {
		return data;
	}

	public void setData(List<SalesTransaction> data) {
		this.data = data;
	}

	/**
	 * @return the currentPage
	 */
	public Integer getCurrentPage() {
		return currentPage;
	}

	/**
	 * @param currentPage the currentPage to set
	 */
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * @return the totalItems
	 */
	public Integer getTotalItems() {
		return totalItems;
	}

	/**
	 * @param totalItems the totalItems to set
	 */
	public void setTotalItems(Integer totalItems) {
		this.totalItems = totalItems;
	}

}
