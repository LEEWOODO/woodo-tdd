package com.example.demo.ch02.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Project        : demo
 * DATE           : 2024/04/05
 * AUTHOR         : dnejdzlr2 (Woodo Lee)
 * EMAIL          : dnejdzlr2@virnect.com
 * DESCRIPTION    :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024/04/05      dnejdzlr2          최초 생성
 */
class TestServiceTest {

	@Test
	void create() {
		TestService testService = new TestService();
		testService.create();
	}
}