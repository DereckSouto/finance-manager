package com.ds.finance_manager.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import com.ds.finance_manager.dto.TransactionRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false, precision = 15, scale = 2)
	private BigDecimal amount;
	
	@Column(nullable = false)
	private LocalDate date;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TransactionType type;
	
	protected Transaction() {
		
	}

	public Transaction(String description, BigDecimal amount, LocalDate date, TransactionType type) {
		this.description = description;
		this.amount = amount;
		this.date = date;
		this.type = type;
	}
	
	public void update(String description, BigDecimal amount, LocalDate date, TransactionType type) {
		this.description = description;
		this.amount = amount;
		this.date = date;
		this.type = type;
	}
	
	public void applyPatch(TransactionRequest request) {
		this.description = Optional.ofNullable(request.getDescription()).orElse(this.description);;
		this.amount = Optional.ofNullable(request.getAmount()).orElse(this.amount);
		this.date = Optional.ofNullable(request.getDate()).orElse(this.date);
		this.type = Optional.ofNullable(request.getType()).orElse(this.type);
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
