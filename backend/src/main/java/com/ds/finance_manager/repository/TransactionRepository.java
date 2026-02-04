package com.ds.finance_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ds.finance_manager.domain.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
