/**
 * 
 */
package com.atn.repository;

import java.time.LocalDate;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.atn.models.SalesTransaction;


/**
 * @author christine
 *
 */
@Repository
public interface IsalesTransaction extends JpaRepository<SalesTransaction, Long> {

	List<SalesTransaction> findByAccountId(String accountId);

	Optional<SalesTransaction> findById(Long id);

	@Query("select st from SalesTransaction st where st.date = :date and st.accountId = :resellerId and st.status = :status")
	List<SalesTransaction> findFiltered(@Param("date") LocalDate date, @Param("resellerId") String resellerId,
			@Param("status") String status);
	@Query("select sum(st.amount)  from SalesTransaction st where st.mnoRealAccountRecorder = :mnoRealAccountRecorder")
	Long amountByMnoRealAccountRecorder(@Param("mnoRealAccountRecorder") int mnoRealAccountRecorder);

}
