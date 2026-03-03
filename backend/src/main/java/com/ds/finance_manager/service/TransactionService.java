package com.ds.finance_manager.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ds.finance_manager.domain.Transaction;
import com.ds.finance_manager.domain.TransactionType;
import com.ds.finance_manager.dto.TransactionRequest;
import com.ds.finance_manager.dto.TransactionResponse;
import com.ds.finance_manager.dto.TransactionSummaryResponse;
import com.ds.finance_manager.exception.TransactionNotFoundException;
import com.ds.finance_manager.repository.TransactionRepository;

@Service
public class TransactionService {

	private final TransactionRepository repository;

	public TransactionService(TransactionRepository repository) {
		this.repository = repository;
	}

	public List<Transaction> findAll() {
		return repository.findAll();
	}

	public Transaction create(TransactionRequest request) {
		if (request.getAmount().signum() <= 0) {
			throw new IllegalArgumentException("Amount must be positive!");
		}

		Transaction transaction = new Transaction(request.getDescription(), request.getAmount(), request.getDate(),
				request.getType());
		return repository.save(transaction);
	}

	public TransactionResponse findById(Long id) {
		Transaction transaction = repository.findById(id).orElseThrow(() -> new TransactionNotFoundException(id));
		return new TransactionResponse(transaction);
	}

	public TransactionResponse update(Long id, TransactionRequest request) {
		Transaction transaction = repository.findById(id).orElseThrow(() -> new TransactionNotFoundException(id));
		transaction.applyPatch(request);
		repository.save(transaction);
		return new TransactionResponse(transaction);
	}

	public void delete(Long id) {
		Transaction transaction = repository.findById(id).orElseThrow(() -> new TransactionNotFoundException(id));
		repository.delete(transaction);
	}

	public List<Transaction> filterTransactionsByType(TransactionType type) {
		if (null != type) {
			return repository.findByType(type);
		}
		return repository.findAll();

	}
	
	public TransactionSummaryResponse getSummary() {
		BigDecimal totalIncome = repository.sumByType(TransactionType.INCOME);
		BigDecimal totalExpense = repository.sumByType(TransactionType.EXPENSE);
		BigDecimal balance = totalIncome.subtract(totalExpense);
		
		return new TransactionSummaryResponse(totalIncome, totalExpense, balance);
	}
	
}
