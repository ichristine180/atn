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

	public List<SalesTransaction> findSalesTransactionBySeller(String accountId,int size);
	
	public Long AmountBymnoRealAccountRecorder(int mnRealAccountRecorder);

	public List<SalesTransaction> filterTransaction(String transactionDate, String status,int size);

}
