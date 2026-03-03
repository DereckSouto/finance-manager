package com.ds.finance_manager.dto;

import java.math.BigDecimal;

public class TransactionSummaryResponse {

	private BigDecimal totalIncome;
	private BigDecimal totalExpense;
	private BigDecimal balance;

	public TransactionSummaryResponse(BigDecimal totalIncome, BigDecimal totalExpense, BigDecimal balance) {
		this.totalIncome = totalIncome;
		this.totalExpense = totalExpense;
		this.balance = balance;
	}

	public BigDecimal getTotalIncome() {
		return totalIncome;
	}

	public BigDecimal getTotalExpense() {
		return totalExpense;
	}

	public BigDecimal getBalance() {
		return balance;
	}
	
}
