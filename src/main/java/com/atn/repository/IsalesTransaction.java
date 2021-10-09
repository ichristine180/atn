/**
 * 
 */
package com.atn.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import com.atn.models.SalesTransaction;

/**
 * @author christine
 *
 */
@Repository
public interface IsalesTransaction extends JpaRepository<SalesTransaction, Long> {

	List<SalesTransaction> findByAccountId(String accountId,Pageable pageable);

	Optional<SalesTransaction> findById(String id);

	@Query("select st from SalesTransaction st where st.date = :date and st.status = :status")
	List<SalesTransaction> filterTransactions(@Param("date") String date, @Param("status") String status,Pageable pageable);

	@Query("select sum(st.amount)  from SalesTransaction st where st.mnoRealAccountRecorder = :mnoRealAccountRecorder")
	Long amountByMnoRealAccountRecorder(@Param("mnoRealAccountRecorder") int mnoRealAccountRecorder);

}
