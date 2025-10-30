package com.dev.refund.exception;

public class RefundNotFoundException extends RuntimeException{
	 public RefundNotFoundException(Long id) {
	        super("Refund not found with id: " + id);
	    }
}
