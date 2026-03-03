package com.ds.finance_manager.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ds.finance_manager.domain.Transaction;
import com.ds.finance_manager.domain.TransactionType;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	List<Transaction> findByType(TransactionType type);
	
	@Query("SELECT COALESCE(SUM(t.amount), 0) FROM Transaction t WHERE t.type = :type")
	BigDecimal sumByType(@Param("type") TransactionType type);
}
