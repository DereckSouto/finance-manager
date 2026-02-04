package com.ds.finance_manager.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.ds.finance_manager.domain.Transaction;
import com.ds.finance_manager.domain.TransactionType;

public class TransactionResponse {

	private Long id;
	private String description;
	private BigDecimal amount;
	private LocalDate date;
	private TransactionType type;
	
	public TransactionResponse(Transaction transaction) {
		this.id = transaction.getId();
		this.description = transaction.getDescription();
		this.amount = transaction.getAmount();
		this.date = transaction.getDate();
		this.type = transaction.getType();
	}

	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public TransactionType getType() {
		return type;
	}
	
}
