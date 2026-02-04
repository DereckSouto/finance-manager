package com.ds.finance_manager.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.ds.finance_manager.domain.TransactionType;

public class TransactionRequest {

	private String description;
	private BigDecimal amount;
	private LocalDate date;
	private TransactionType type;
	
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
