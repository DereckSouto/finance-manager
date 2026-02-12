package com.ds.finance_manager.exception;

public class TransactionNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public TransactionNotFoundException(Long id) {
		super("Transaction with id " + id + " not found!");
	}

}
