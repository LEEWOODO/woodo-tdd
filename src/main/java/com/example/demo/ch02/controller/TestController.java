package com.example.demo.ch02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ch02.service.TestService;

import lombok.RequiredArgsConstructor;

/**
 * Project        : demo
 * DATE           : 2024/04/01
 * AUTHOR         : dnejdzlr2 (Woodo Lee)
 * EMAIL          : dnejdzlr2@virnect.com
 * DESCRIPTION    :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024/04/01      dnejdzlr2          최초 생성
 */
@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

	private final TestService testService;

	// public TestController(TestService testService) {
	// 	this.testService = testService;
	// }

	@GetMapping
	public ResponseEntity<String> test() {
		System.out.println("TestController.test() called");
		System.out.println("TestController.test() called222");
		testService.create();

		// performanceRepository.findAll();
		return new ResponseEntity<>("Hello, World!", HttpStatus.OK);
	}
}
