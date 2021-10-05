/**
 * 
 */
package com.atn.services;

import java.util.List;

import com.atn.models.SalesTransaction;

/**
 * @author christine
 *
 */

public interface IsalesTransactionService {
	String NAME = "salesTransactionService";

	public SalesTransaction create(SalesTransaction st);

	public List<SalesTransaction> findSalesTransactionBySeller(String accountId);

	public List<SalesTransaction> findFilteredTransaction();
	
	public Long AmountBymnoRealAccountRecorder(int mnRealAccountRecorder);

}
