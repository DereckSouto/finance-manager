package com.ds.finance_manager.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ds.finance_manager.dto.ApiErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiErrorResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		Map<String, Object> map = new HashMap<>();
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			map.put(error.getField(), error.getDefaultMessage());
		}
		for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
			map.put(error.getObjectName(), error.getDefaultMessage());
		}
		ApiErrorResponse errorResponse = new ApiErrorResponse("Invalid input", LocalDateTime.now(), map);

		return ResponseEntity.badRequest().body(errorResponse);
	}

}
