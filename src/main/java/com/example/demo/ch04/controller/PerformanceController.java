package com.example.demo.ch04.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ch04.domain.dto.PerformanceInfo;
import com.example.demo.ch04.service.PerformanceService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
/**
 * Project        : demo
 * DATE           : 2024/04/26
 * AUTHOR         : dnejdzlr2 (Woodo Lee)
 * EMAIL          : dnejdzlr2@virnect.com
 * DESCRIPTION    :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024/04/26      dnejdzlr2          최초 생성
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/performance")
@Slf4j
public class PerformanceController {
	private final PerformanceService performanceService;
	//    private final PerformanceRepository performanceRepository;

	@GetMapping
	public ResponseEntity<List<PerformanceInfo>> getPerformanceAllList() {
		log.info("Requested ::: getInfo");
		//        performanceRepository.findAll();
		return ResponseEntity.ok().body(performanceService.getAllPerformanceInfo());
	}
}