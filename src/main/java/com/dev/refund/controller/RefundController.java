package com.dev.refund.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.refund.entity.Refund;
import com.dev.refund.exception.RefundNotFoundException;
import com.dev.refund.service.RefundService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/refund")
public class RefundController {
	
	@Autowired
	private RefundService refundService;
	
	@PostMapping
	public ResponseEntity<Refund> create(@Valid @RequestBody Refund refund) {
		return ResponseEntity.ok(refundService.createRefund(refund));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Refund> get(@PathVariable Long id){
		Refund refund = refundService.getRefundById(id)
				.orElseThrow(() ->new RefundNotFoundException(id));
		return ResponseEntity.ok(refund);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Refund> update(@PathVariable Long id, @Valid @RequestBody Refund refund){
		return ResponseEntity.ok(refundService.updateRefund(id, refund));
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Refund> partialUpdate(@PathVariable Long id, @RequestBody Refund refund) {
        return ResponseEntity.ok(refundService.partialUpdateRefund(id, refund));
    }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		refundService.deleteRefund(id);
		return ResponseEntity.noContent().build();
	}
}