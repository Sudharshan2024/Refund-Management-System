package com.dev.refund.service;

import java.util.Optional;

import com.dev.refund.entity.Refund;

public interface RefundService {
	
	Refund createRefund(Refund refund);
    Optional<Refund> getRefundById(Long id);
    Refund updateRefund(Long id, Refund refund);
    Refund partialUpdateRefund(Long id, Refund partialRefund);
}
