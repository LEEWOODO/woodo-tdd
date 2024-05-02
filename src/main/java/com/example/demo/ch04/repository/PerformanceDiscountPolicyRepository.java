package com.example.demo.ch04.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.ch04.domain.entity.ticketing.PerformanceDiscountPolicy;

@Repository
public interface PerformanceDiscountPolicyRepository extends JpaRepository<PerformanceDiscountPolicy, UUID> {
	PerformanceDiscountPolicy findByPerformanceIdAndName(UUID performanceId, String policyName);
}
