package com.dev.refund.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dev.refund.entity.Refund;
import com.dev.refund.exception.RefundNotFoundException;
import com.dev.refund.repository.RefundRepository;

@Service
public class RefundServiceImpl implements RefundService{
	
	private static final Logger logger = LoggerFactory.getLogger(RefundServiceImpl.class);
	
	@Autowired
	private RefundRepository refundRepository;
	
	@Override
	public Refund createRefund(Refund refund) {
		logger.info("Creating new refund for orderId: {}", refund.getOrderId());
        return refundRepository.save(refund);
    }
	
	@Override
	public Optional<Refund> getRefundById(Long id) {
        return refundRepository.findById(id);
    }
	
	@Override
	public Refund updateRefund(Long id, Refund refund) {
		logger.info("Updating refund with id: {}", id);
		Refund existingRefund = refundRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Refund not found with id: " + id));
        
		//Update only allowed fields
        existingRefund.setOrderId(refund.getOrderId());
        existingRefund.setUserId(refund.getUserId());
        
        //Keep createdTimestamp as is (do not overwrite)
        existingRefund.setUpdatedTimestamp(LocalDateTime.now());
        
        return refundRepository.save(existingRefund);
    }
	
	@Override
	public Refund partialUpdateRefund(Long id, Refund partialRefund) {
        Refund existing = refundRepository.findById(id).orElseThrow();
        if (partialRefund.getOrderId() != null) existing.setOrderId(partialRefund.getOrderId());
        if (partialRefund.getUserId() != null) existing.setUserId(partialRefund.getUserId());
        return refundRepository.save(existing);
    }

	@Override
	public void deleteRefund(Long id) {
		logger.warn("Deleting refund with id: {}", id);
		if(!refundRepository.existsById(id)) {
			throw new RefundNotFoundException(id);
		}
		refundRepository.deleteById(id);
	}
}