package com.dev.refund.entity;

import java.time.LocalDateTime;



import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@JsonPropertyOrder({ "refundId", "orderId", "userId", "createdTimestamp", "updatedTimestamp" })
@Entity
@Table(name = "refund")
public class Refund {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long refundId;
	
	@NotNull(message = "Order ID cannot be null")
	@Positive(message = "Order ID must be positive")
    private Long orderId;
	
	@NotNull(message = "User ID cannot be null")
    @Positive(message = "User ID must be positive")
    private Long userId;
    
    
    private LocalDateTime createdTimestamp;
    
    private LocalDateTime updatedTimestamp;

    @PrePersist
    protected void onCreate() {
        this.createdTimestamp = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedTimestamp = LocalDateTime.now();
    }

	public Long getRefundId() {
		return refundId;
	}

	public void setRefundId(Long refundId) {
		this.refundId = refundId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
    
    public LocalDateTime getCreatedTimestamp() {
    	return createdTimestamp;
    }
    
    public void setCreatedTimestamp(LocalDateTime createdTimestamp){
    	this.createdTimestamp = createdTimestamp;
    }
    
    public LocalDateTime getUpdatedTimestamp() {
        return updatedTimestamp;
    }

    public void setUpdatedTimestamp(LocalDateTime updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }
}
