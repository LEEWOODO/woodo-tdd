package com.example.demo.ch02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.ch02.domain.Performance;

/**
 * Project        : demo
 * DATE           : 2024/04/08
 * AUTHOR         : dnejdzlr2 (Woodo Lee)
 * EMAIL          : dnejdzlr2@virnect.com
 * DESCRIPTION    :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024/04/08      dnejdzlr2          최초 생성
 */
@Repository
public interface PerformanceRepository extends JpaRepository<Performance, Long> {
}
