package com.ds.finance_manager.controller;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ds.finance_manager.domain.Transaction;
import com.ds.finance_manager.dto.TransactionRequest;
import com.ds.finance_manager.dto.TransactionResponse;
import com.ds.finance_manager.service.TransactionService;

import jakarta.validation.Valid;

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
	public ResponseEntity<Void> patch(@PathVariable Long id, @RequestBody TransactionRequest request) {
		service.update(id, request);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<TransactionResponse> create(@Valid @RequestBody TransactionRequest request) {
		Transaction transaction = service.create(request);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(transaction.getId()).toUri();
		TransactionResponse response = new TransactionResponse(transaction);
		return ResponseEntity.created(location).body(response);
	}
	
}
