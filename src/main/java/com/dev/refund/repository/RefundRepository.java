package com.dev.refund.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.refund.entity.Refund;

public interface RefundRepository extends JpaRepository<Refund, Long>{

}
