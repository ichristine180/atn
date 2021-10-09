/**
 * 
 */
package com.atn.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.atn.models.SalesTransaction;
import com.atn.repository.IsalesTransaction;

/**
 * @author christine
 *
 */

@Service
public class SalesTransactionService implements IsalesTransactionService {
	@Autowired
	private IsalesTransaction salesRepository;

	@Override
	public SalesTransaction create(SalesTransaction st) {
		try {
			return salesRepository.save(st);
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public List<SalesTransaction> findSalesTransactionBySeller(String accountId,int size) {

		try {
			return salesRepository.findByAccountId(accountId,PageRequest.of(0,size));
		} catch (final Exception ex) {
			throw ex;
		}
	}


	@Override
	public Long AmountBymnoRealAccountRecorder(int mnRealAccountRecorder) {
		try {
			return salesRepository.amountByMnoRealAccountRecorder(mnRealAccountRecorder);
		} catch (final Exception ex) {
			throw ex;
		}
	}

	@Override
	public List<SalesTransaction> filterTransaction(String transactionDate, String status,int size) {
		try {
			return salesRepository.filterTransactions(transactionDate,status,PageRequest.of(0,size));
		} catch (final Exception ex) {
			throw ex;
		}
	}

}
