package com.ds.finance_manager.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.ds.finance_manager.domain.TransactionType;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class TransactionRequest {

	private String description;
	
	@NotNull
	@Positive
	private BigDecimal amount;
	
	@NotNull
	private LocalDate date;
	
	@NotNull
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
