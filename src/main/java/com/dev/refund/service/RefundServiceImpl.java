package com.dev.refund.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.refund.entity.Refund;
import com.dev.refund.repository.RefundRepository;

@Service
public class RefundServiceImpl implements RefundService{
	
	@Autowired
	private RefundRepository refundRepository;
	
	public Refund createRefund(Refund refund) {
        return refundRepository.save(refund);
    }
	
	public Optional<Refund> getRefundById(Long id) {
        return refundRepository.findById(id);
    }
	
	public Refund updateRefund(Long id, Refund refund) {
        
		Refund existingRefund = refundRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Refund not found with id: " + id));
        
		//Update only allowed fields
        existingRefund.setOrderId(refund.getOrderId());
        existingRefund.setUserId(refund.getUserId());
        
        //Keep createdTimestamp as is (do not overwrite)
        existingRefund.setUpdatedTimestamp(LocalDateTime.now());
        
        return refundRepository.save(existingRefund);
    }
	
	public Refund partialUpdateRefund(Long id, Refund partialRefund) {
        Refund existing = refundRepository.findById(id).orElseThrow();
        if (partialRefund.getOrderId() != null) existing.setOrderId(partialRefund.getOrderId());
        if (partialRefund.getUserId() != null) existing.setUserId(partialRefund.getUserId());
        return refundRepository.save(existing);
    }

}