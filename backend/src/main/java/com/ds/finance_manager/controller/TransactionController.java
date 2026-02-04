package com.ds.finance_manager.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ds.finance_manager.domain.Transaction;
import com.ds.finance_manager.dto.TransactionRequest;
import com.ds.finance_manager.dto.TransactionResponse;
import com.ds.finance_manager.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

	private final TransactionService service;
	
	public TransactionController(TransactionService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<TransactionResponse> getAll() {
		return service.findAll().stream().map(TransactionResponse::new).toList();
	}
	
	@GetMapping("/{id}")
	public TransactionResponse getId(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PatchMapping("/{id}")
	public TransactionResponse update(@PathVariable Long id, @RequestBody TransactionRequest request) {
		return service.update(id, request);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public TransactionResponse create(@RequestBody TransactionRequest request) {
		Transaction transaction = service.create(request.getDescription(), request.getAmount(), request.getDate(), request.getType());
		
		return new TransactionResponse(transaction);
	}
	
}
