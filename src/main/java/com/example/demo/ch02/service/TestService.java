package com.example.demo.ch02.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestService {
	// private static final Logger log = LoggerFactory.getLogger(TestService.class);

	public void create() {
		// log.info("TestService.create() called");
		System.out.println("TestService.create() called");
		System.out.println("TestService.create() called");
		System.out.println("TestService.create() called");
	}
}







