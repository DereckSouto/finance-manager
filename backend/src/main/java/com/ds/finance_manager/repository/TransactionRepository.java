package com.ds.finance_manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ds.finance_manager.domain.Transaction;
import com.ds.finance_manager.domain.TransactionType;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	List<Transaction> findByType(TransactionType type);
	
}
