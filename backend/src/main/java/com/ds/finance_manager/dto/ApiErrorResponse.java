package com.ds.finance_manager.dto;

import java.time.LocalDateTime;
import java.util.Map;

public class ApiErrorResponse {

	private String message;
	private LocalDateTime timestamp;
	private Map<String, Object> invalidInputs;
	
	public ApiErrorResponse(String message, LocalDateTime timestamp, Map<String, Object> invalidInputs) {
		this.message = message;
		this.timestamp = timestamp;
		this.invalidInputs = invalidInputs;
	}
	
	public String getMessage() {
		return message;
	}
	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	
	public Map<String, Object> getInvalidInputs() {
		return invalidInputs;
	}
	
}
